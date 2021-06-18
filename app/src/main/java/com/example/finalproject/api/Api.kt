package com.example.finalproject

import retrofit2.Response
import retrofit2.http.*

interface Api {

    @GET("everything")
    suspend fun getNews(
        @Query("q") q : String,
        @Query("apiKey") apiKey : String,
        @Query("language") language : String
    ) : Response<APIResponse>

}