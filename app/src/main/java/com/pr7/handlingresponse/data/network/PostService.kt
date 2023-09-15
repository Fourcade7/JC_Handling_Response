package com.pr7.handlingresponse.data.network

import com.pr7.handlingresponse.data.model.PostModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PostService {

    @GET("postss")
    suspend  fun getAllPosts(): Response<ArrayList<PostModel>>

}