package com.example.coroutinesexamples.Coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutinesexamples.R
import com.example.coroutinesexamples.databinding.ActivitySequentialCoroutinesBinding
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

class SequentialCoroutinesActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySequentialCoroutinesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_sequential_coroutines)
        binding = ActivitySequentialCoroutinesBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)
        binding.mainButton.setOnClickListener {
            binding.sqText.text = ""

            sequentialRequest()
        }

        binding.mainButton1.setOnClickListener {
            binding.sqText.text = ""

            sequentialRequestUsingDifferentCoroutines()

        }
    }

    private fun sequentialRequest() {
        CoroutineScope(IO).launch {
            val elapsedTime = measureTimeMillis {
                setTextOnMainThread("Calling API1 in : ${Thread.currentThread().name}")
                val result1 = getResult1FromApi()
                setTextOnMainThread("Got result 1 : $result1")

                setTextOnMainThread("Calling API2 in: ${Thread.currentThread().name}")
                val result2 =getResult2FromApi(result1)
                setTextOnMainThread("Got Result 2: $result2")
            }
            setTextOnMainThread("Elapsed time: $elapsedTime")
        }
    }

    private fun sequentialRequestUsingDifferentCoroutines() {
        CoroutineScope(IO).launch {
            val elapsedTime = measureTimeMillis {
                val result1=async {
                    setTextOnMainThread("Calling Api in ${Thread.currentThread().name}")

                    getResult1FromApi()
                }.await()
                setTextOnMainThread("Got result 1 $result1")

                val result2 = async {
                    setTextOnMainThread("Calling API2 In:  ${Thread.currentThread().name}")
                    getResult2FromApi(result1)
                }.await()
                setTextOnMainThread("Got result 2: $result2")
            }
            setTextOnMainThread("Elapsed time: $elapsedTime")
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

    private suspend fun getResult2FromApi(result1: String): String {
        delay(1700)
        if (result1 == "Result #1") {
            return "Result #2"
        } else {
            throw CancellationException("Result 1 was incorrect...")
        }
    }
}