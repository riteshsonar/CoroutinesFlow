package com.example.coroutinesexamples.Coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutinesexamples.R
import com.example.coroutinesexamples.databinding.ActivityJobsParallelBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

class JobsParallelActivity : AppCompatActivity() {

    private lateinit var parentJob: Job
    private lateinit var binding: ActivityJobsParallelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_jobs_parallel)
        binding = ActivityJobsParallelBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)
        binding.mainButton.setOnClickListener {
            binding.sqText.text= ""
            parallelApiRequestUsingJob()
        }
        binding.mainButton1.setOnClickListener {
            binding.sqText.text =""
            parallelApiRequestUsingAsyncAwait()
        }
    }
    private fun parallelApiRequestUsingJob() {
        val startTime = System.currentTimeMillis()
        parentJob = CoroutineScope(Dispatchers.IO).launch {

            val job1 = launch {
                setTextOnMainThread("Launching Api1 in thread: ${Thread.currentThread().name}")
                val result1 = getResult1FromApi()
                setTextOnMainThread("Got $result1")
            }

            val job2 = launch {
                setTextOnMainThread("Launching Api2 in thread: ${Thread.currentThread().name}")
                val result2 = getResult2FromApi()
                setTextOnMainThread("Got $result2")
            }
        }

        parentJob.invokeOnCompletion {
            setNewText("ElapsedTime: ${System.currentTimeMillis() - startTime}")
        }
    }

    private fun parallelApiRequestUsingAsyncAwait() {
        CoroutineScope(Dispatchers.IO).launch {

            val elapsedTime = measureTimeMillis {

                val result1 = async {
                    setTextOnMainThread("Launching Api1 in thread: ${Thread.currentThread().name}")
                    getResult1FromApi()
                }

                val result2 = async {
                    setTextOnMainThread("Launching Api2 in thread: ${Thread.currentThread().name}")
                    getResult2FromApi()
                }

                setTextOnMainThread("Got ${result1.await()}")
                setTextOnMainThread("Got ${result2.await()}")
            }
            setTextOnMainThread("ElapsedTime:${elapsedTime}")
        }
    }

    private fun setNewText(text: String) {
        val newText = binding.sqText.text.toString() + "\n$text"
        binding.sqText.text = newText
    }

    private suspend fun setTextOnMainThread(input: String) {
        withContext(Dispatchers.Main) {
            setNewText(input)
        }
    }

    private suspend fun getResult1FromApi(): String {
        delay(1000)
        return "Result #1"
    }

    private suspend fun getResult2FromApi(): String {
        delay(1700)
        return "Result #2"
    }
}