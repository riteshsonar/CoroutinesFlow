package com.example.coroutinesexamples.Coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutinesexamples.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class AsyncAwaitCoroutineActivity : AppCompatActivity() {

    companion object{
        val TAG: String
            get() = "AsyncAwaitActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_await_coroutine)

        GlobalScope.launch(Dispatchers.IO) {
            val time = measureTimeMillis {
                val answer1 = networkCall1()
                val answer2 = networkCall2()
                Log.d(TAG,"Answer1 is $answer1")
                Log.d(TAG,"Answer2 is $answer2")
            }
            Log.d(TAG," Requests took $time ms. ")
        }
    }

    suspend fun networkCall1():String{
        delay(3000L)
        return "Answer 1"
    }
    suspend fun networkCall2():String{
        delay(3000L)
        return "Answer 2"
    }
}