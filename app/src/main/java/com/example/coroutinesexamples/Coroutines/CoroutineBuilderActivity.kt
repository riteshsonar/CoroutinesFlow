package com.example.coroutinesexamples.Coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutinesexamples.R
import com.example.coroutinesexamples.databinding.ActivityCoroutineBuilderBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class CoroutineBuilderActivity : AppCompatActivity() {

     private lateinit var binding : ActivityCoroutineBuilderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_coroutine_builder)
        binding= ActivityCoroutineBuilderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.launchButton.setOnClickListener {
            startCoroutineUsingLaunch()
        }
        binding.asyncButton.setOnClickListener {
            CoroutineScope(Main).launch { startCoroutineUsingAsync()  }

        }
        binding.runBlockingButton.setOnClickListener { startCoroutineUsingRunBlocking() }
    }
    private fun startCoroutineUsingLaunch() {
        val job: Job = CoroutineScope(Dispatchers.IO).launch {
            setText("Launch ${getStringResult()}")
        }
    }

    private suspend fun startCoroutineUsingAsync() {
        val deferred: Deferred<String> = CoroutineScope(Dispatchers.IO).async {
            return@async getStringResult()
        }

        setText("Await ${deferred.await()}")
    }

    private fun startCoroutineUsingRunBlocking() {
        val result = runBlocking {
            getStringResult()
        }

        CoroutineScope(Dispatchers.IO).launch { setText("RunBlocking $result") }
    }

    private suspend fun setText(text: String) {
        withContext(Main) {
            binding.coroutineText.text = text
        }
    }

    private suspend fun getStringResult(): String {
        delay(1000)
        return "Hello Paytm"
    }
}