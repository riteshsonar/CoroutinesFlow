package com.example.coroutinesexamples.Coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutinesexamples.R
import com.example.coroutinesexamples.databinding.ActivityNestedGlobalScopeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NestedGlobalScopeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNestedGlobalScopeBinding
    private lateinit var parentJob : Job
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_nested_global_scope)
        binding = ActivityNestedGlobalScopeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.startNormalJob.setOnClickListener {
            binding.textView.text = ""
            startNormalJob()
        }

        binding.startGlobalScopeJob.setOnClickListener {
            binding.textView.text = ""
            startGlobalScopeJob()
        }

        binding.cancelJob.setOnClickListener {
            parentJob.cancel()
        }
    }



    private fun startNormalJob() {

        val startTime = System.currentTimeMillis()
        parentJob = CoroutineScope(Main).launch {
            async { //Job1
                doWork(1)
            }.await()

            async { //job2
                doWork(2)

             }.await()
        }
        parentJob.invokeOnCompletion {
            if (it != null){
                setNewText("Cancel Start Job After ${System.currentTimeMillis() - startTime} ms")
            }else{
                setNewText("Completed job in ${System.currentTimeMillis() - startTime} ms")
            }
        }
    }

    private fun startGlobalScopeJob() {
        val startTime = System.currentTimeMillis()
        parentJob = GlobalScope.launch(Main) { //ParentJob

            GlobalScope.async {//Global Scope Job
                doWork(1)
            }.await()

            GlobalScope.async {//Global Scope Job
                doWork(2)
            }.await()
        }
        parentJob.invokeOnCompletion {
            if ( it != null){
                setNewText("Cancelled job after ${System.currentTimeMillis() - startTime} ms")
            }else{
                setNewText("Completed Job in ${System.currentTimeMillis() - startTime} ms")
            }
        }
    }

    private suspend fun doWork(i: Int) {
        delay(1500)
        withContext(Dispatchers.Main) {
            setNewText("Work $i done!!")
        }
    }

    private fun setNewText(text: String) {
        val newText = binding.textView.text.toString() + "\n$text"
        binding.textView.text = newText
    }
}