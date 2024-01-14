package com.example.coroutinesexamples.Retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutinesexamples.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.reflect.KClass

class RetrofitActivity : AppCompatActivity() {
    val TAG = "RetrofitActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)


        val api= RetrofitHelper.getInstance().create(MyApI::class.java)

        GlobalScope.launch {
            val result = api.getComments()
            if (result != null){
                Log.d(TAG,result.body().toString())
            }
        }
        

    }
}