package com.pr7.handlingresponse.repository

import com.pr7.handlingresponse.data.model.PostModel
import kotlinx.coroutines.flow.Flow

interface MainRepository {


    fun getAllposts():Flow<Result<List<PostModel>>>


}

