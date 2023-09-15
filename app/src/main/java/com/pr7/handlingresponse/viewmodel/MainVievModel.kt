package com.pr7.handlingresponse.viewmodel

import androidx.lifecycle.MutableLiveData
import com.pr7.handlingresponse.data.model.PostModel
import com.pr7.handlingresponse.data.model.Resource


interface MainVievModel {

    fun getAllPosts()

    val postsLivedata:MutableLiveData<Resource<List<PostModel>>>

}