package com.example.coroutinesexamples

import android.os.Build.VERSION_CODES.N
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield


class MainActivity : AppCompatActivity() {
    private val TAG :String= "Kotlin"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /* CoroutineScope(Dispatchers.Main).launch {
            task1()
        }*/
        GlobalScope.launch {

        }
        CoroutineScope(Dispatchers.Main).launch {
            printFollowers()
        }
        lifecycle.addObserver(Observer())
        Log.d("Main", "Activity OnCreate")
    }

    private suspend fun printFollowers(){
        val job= CoroutineScope(Dispatchers.IO).launch {
            var fb=async { getFollowers() }
            var insta=async { getInstaFollowers() }
            Log.d(TAG,"FaceBook Followers ${fb.await()} insta ${insta.await()}")

        }
        //join function handel a seqvance of execution
       // job.join()

    }
    private suspend fun getFollowers():Int{
        delay(10000)
        return 54
    }
    private suspend fun getInstaFollowers():Int{
        delay(10000)
        return 113
    }
    suspend fun task1(){
        Log.d(TAG,"Starting Task 1")
        //suspend function when a thread for wait state suspend coroutine for next execution
        yield()
        Log.d(TAG,"Ending Task 1")
    }
    suspend fun task2(){
        Log.d(TAG,"Starting Task2")
        yield()
        Log.d(TAG,"Ending Task2")
    }



}