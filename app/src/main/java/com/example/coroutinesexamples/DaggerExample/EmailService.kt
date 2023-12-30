package com.example.coroutinesexamples.DaggerExample

import android.util.Log

class EmailService {
    companion object{
        val TAG:String = "EmailService"
    }
    fun send(to:String, from:String,body:String?){

        Log.d(TAG,"Email String")
    }
}