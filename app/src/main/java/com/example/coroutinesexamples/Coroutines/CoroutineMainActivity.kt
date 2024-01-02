package com.example.coroutinesexamples.Coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutinesexamples.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineMainActivity : AppCompatActivity() {
    val TAG= "CoroutineActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_main)

        GlobalScope.launch {
            Log.e(TAG,"says hello from thread ${Thread.currentThread().name}")
            val networkcall= doNetworkCall()
            Log.e(TAG,"call the network $networkcall")

        }
    }
    suspend fun doNetworkCall():String{
        delay(1000L)
        Log.d(TAG,"Network call using suspend fun")
        return "this is answer"
    }
}