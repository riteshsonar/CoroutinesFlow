package com.example.coroutinesexamples.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val baseUrl= "https://quotable.io/"
    fun getInstance():Retrofit{
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())// we add converted factory to convert JSON object into Java Object
            .build()

    }
}