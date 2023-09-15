package com.pr7.handlingresponse.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pr7.handlingresponse.data.model.PostModel
import com.pr7.handlingresponse.data.model.Resource
import com.pr7.handlingresponse.repository.impl.RepositoryImpl
import com.pr7.handlingresponse.viewmodel.MainVievModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainViewModelImpl constructor():MainVievModel,ViewModel(){

    override val postsLivedata: MutableLiveData<Resource<List<PostModel>>> =MutableLiveData()

    val repository =RepositoryImpl()
    override fun getAllPosts() {
        postsLivedata.postValue(Resource.Loading)
    repository.getAllposts().onEach{
        it.onSuccess {
            postsLivedata.postValue(Resource.Success(it))
        }

        it.onFailure {

            postsLivedata.postValue(Resource.Error(it))
        }


    }.launchIn(viewModelScope)
    }



}