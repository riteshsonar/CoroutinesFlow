package com.example.coroutinesexamples.Coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutinesexamples.R
import com.example.coroutinesexamples.databinding.ActivityHandlingExceptionBinding
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext

class HandlingExceptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHandlingExceptionBinding

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_handling_exception)

        binding = ActivityHandlingExceptionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.exceptionHandlerButton.setOnClickListener {
            binding.exceptionText.text = ""
            startJob()
        }
        binding.supervisorJobButton.setOnClickListener {
            binding.exceptionText.text = ""
            startSupervisorJob()
        }
    }

    @InternalCoroutinesApi
    private fun startJob() {
        val handler = CoroutineExceptionHandler { _, throwable ->
            setNewText("Exception occurred in Coroutine")
        }
        val parentJob = CoroutineScope(Main).launch(handler) {
            /*
             //------------Work 2 -------------
            val job2 = async {
                setTextOnMainThread("Work Done - ${doWork(2)}")
            }

            job2.invokeOnCompletion {
                if (it != null) {
                    setNewText("Error getting result 2: ${it.message}")
                }
            }

            job2.await()
            //------------Work 3 -------------
            val job3 = async {
                setTextOnMainThread("Work Done - ${doWork(3)}")
            }
            job3.invokeOnCompletion {
                if (it != null) {
                    setNewText("Error getting result 3: ${it.message}")
                }
            }
            job3.await()*/
            //------------Work 1 -------------
            val job1 = async {
                setTextOnMainThread("Work Done - ${doWork(1)}")
            }
            job1.invokeOnCompletion {
                if (it != null) {
                    setNewText("Error getting result 1: ${it.message}")
                }
            }
            job1.await()

            //--------------- Work 2 ----------------------
            val job2 = async {
                setTextOnMainThread(" Work Done - ${doWork(2)}")
            }
            job2.invokeOnCompletion {
                if (it != null) {
                    setNewText("Error getting result 2: ${it.message}")
                }
            }
            job2.await()

            //--------------------Work 3 ----------------------------
            val job3 = async {
                setTextOnMainThread("Work Done - ${doWork(3)}")
            }
            job3.invokeOnCompletion {
                if (it != null) {
                    setNewText("Error getting result 3: ${it.message}")
                }
            }
            job3.await()
        }
        parentJob.invokeOnCompletion {
            if (it != null) {
                setNewText("Parent Job failed: ${it.message}")
            } else {
                setNewText("Parent Job Success")
            }
        }

    }

    @InternalCoroutinesApi
    private fun startSupervisorJob() {
        val handler = CoroutineExceptionHandler { _, throwable ->
            setNewText("Exception occurred in Coroutine")
        }

        val parentJob = CoroutineScope(Main).launch(handler) {

            supervisorScope {

                //------------Work 1 -------------
                val job1 = launch {
                    setTextOnMainThread("Work Done - ${doWork(1)}")
                }.invokeOnCompletion {
                    if (it != null) {
                        setNewText("Error getting result 1: ${it.message}")
                    }
                }

                //------------Work 2 -------------
                val job2 = launch {
                    setTextOnMainThread("Work Done - ${doWork(2)}")
                }.invokeOnCompletion {
                    if (it != null) {
                        setNewText("Error getting result 2: ${it.message}")
                    }
                }

                //------------Work 3 -------------
                val job3 = launch {
                    setTextOnMainThread("Work Done - ${doWork(3)}")
                }.invokeOnCompletion {
                    if (it != null) {
                        setNewText("Error getting result 3: ${it.message}")
                    }
                }

            }
        }

        parentJob.invokeOnCompletion {
            if (it != null) {
                setNewText("Parent job failed: ${it.message}")
            } else {
                setNewText("Parent job Success")
            }
        }
    }

    @InternalCoroutinesApi
    private suspend fun doWork(num: Int): Int {
        delay(num * 500L)
        if (num == 2) {
            throw Exception("Wrong argument: $num")
        }
        return num
    }

    private fun setNewText(text: String) {
        val newText = binding.exceptionText.text.toString() + "\n $text"
        binding.exceptionText.text = newText

    }

    private suspend fun setTextOnMainThread(input: String) {
        withContext(Dispatchers.Main) {
            setNewText(input)
        }
    }
}