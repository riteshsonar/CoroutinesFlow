package com.example.coroutinesexamples.DaggerExample

import android.util.Log
import javax.inject.Inject

class EmailService @Inject constructor() {
    companion object{
        val TAG:String = "EmailService"
    }
    fun send(to:String, from:String,body:String?){

        Log.d(TAG,"Email String")
    }
}