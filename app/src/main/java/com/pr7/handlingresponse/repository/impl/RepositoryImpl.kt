package com.pr7.handlingresponse.repository.impl

import com.pr7.handlingresponse.data.model.PostModel
import com.pr7.handlingresponse.data.network.RetrofitInstance
import com.pr7.handlingresponse.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class RepositoryImpl constructor():MainRepository {

    val api=RetrofitInstance.getApi()

    override fun getAllposts()=flow<Result<List<PostModel>>> {
       val response =api.getAllPosts()

        if (response.isSuccessful){
            emit(Result.success(response.body()!!))
        }else{
            emit(Result.failure(Exception(response.errorBody()
                !!.string())))
        }

    }.flowOn(Dispatchers.IO)
}