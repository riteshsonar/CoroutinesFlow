package com.example.coroutinesexamples.Coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutinesexamples.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CancelActivity : AppCompatActivity() {
    private val TAG:String="Kotlin"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancel)
        GlobalScope.launch(Dispatchers.Main){
            execute()
        }

    }

    private suspend fun execute(){
        val parentJob= GlobalScope.launch(Dispatchers.Main){
            Log.d(TAG,"context $coroutineContext")
            val childJob=launch {
                Log.d(TAG,"context $coroutineContext")
            }
        }

    }
}