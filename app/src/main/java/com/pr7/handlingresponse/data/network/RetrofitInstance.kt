package com.pr7.handlingresponse.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    fun getApi(): PostService {
        val retrofit= Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val postService=retrofit.create(PostService::class.java)
        return postService
    }
}