package com.example.newsapp.data.remote

import com.example.newsapp.domain.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    /*
     implementing api call from remote server
     we are using GET request which is a retrofit method used to make get requests
    */
    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("category") category: String,
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
    /*
     companion object is an object that contains both the base_url and api ke
    */
    companion object{
        const val BASE_URL = "https://newsapi.org/v2/"
        const val API_KEY = "78f184e0499e48bda421d2977eaa6d35"
    }
}