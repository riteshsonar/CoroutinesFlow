package com.example.coroutinesexamples.Retrofit

import retrofit2.Response
import retrofit2.http.GET


interface MyApI {
    @GET("/quotes")
    suspend fun getComments(): Response<QuoteList>

}