package com.example.coroutinesexamples.DaggerExample

import android.util.Log
import javax.inject.Inject

class UserRepository @Inject constructor(){
    companion object{
       val TAG:String ="User Repository"
    }
    fun saveUser(email: String, password: String) {
            Log.d(TAG,"User Saved in DB")
    }
}