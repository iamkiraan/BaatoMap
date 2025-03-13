package com.example.baatomap.ApiWork

import com.example.baatomap.DataClasses.SearchDataClass
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("search")
    suspend fun SearchPalce(
        @Query("q") query: String,
        @Query("key") apikey : String,
        @Query("limit") limit: Int = 5
    ) : SearchDataClass
}