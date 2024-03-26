package com.example.coroutinesexamples.Coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.tools.build.jetifier.core.utils.Log
import com.example.coroutinesexamples.R
import com.example.coroutinesexamples.databinding.ActivityBasicCoroutinesTestBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BasicCoroutinesTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBasicCoroutinesTestBinding
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_coroutines_test)
        binding = ActivityBasicCoroutinesTestBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.mainButton.setOnClickListener {
            if (count == 5) {
                blockThread()
            }
            setText()
        }
        binding.mainButton1.setOnClickListener {
            if (count ==5){
                doNotBlockMainThread()
            }
            setText()
        }
        binding.mainButton2.setOnClickListener {
            if (count ==5){
                blockMainThreadUsingCoroutine()
            }
            setText()
        }
        binding.mainButton3.setOnClickListener {
            count =0
            setText()
        }
    }


    /**
     * Launched new Coroutine using Coroutine Builder "launch"
     */
    private fun doNotBlockMainThread() {
        CoroutineScope(Dispatchers.IO).launch {
            Log.v("Patym",Thread.currentThread().name)
            Log.v("Patym","Job Started")
            delay(4000)
            Log.v("Patym","Job Ended")
        }
    }

    private fun blockMainThreadUsingCoroutine() {
        runBlocking {
            Log.v("Patym","Job Started")
            delay(4000)
            Log.v("Patym","Job Ended")
        }    }

    private fun blockThread() {
        Thread.sleep(4000)
    }
    private fun setText(){
        binding.mainText.text =(++count).toString()
    }
}