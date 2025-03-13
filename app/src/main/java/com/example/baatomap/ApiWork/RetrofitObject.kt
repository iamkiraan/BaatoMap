package com.example.baatomap.ApiWork

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {

    val retrofit =Retrofit.Builder()
        .baseUrl("https://api.baato.io/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val baatoSearchService = retrofit.create(ApiInterface::class.java)
}