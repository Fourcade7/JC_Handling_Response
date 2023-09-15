package com.pr7.handlingresponse

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

import androidx.lifecycle.lifecycleScope
import com.pr7.handlingresponse.data.model.Resource
import com.pr7.handlingresponse.data.network.RetrofitInstance
import com.pr7.handlingresponse.viewmodel.impl.MainViewModelImpl

import kotlinx.coroutines.launch

private const val TAG = "PR77777"
class MainActivity : ComponentActivity() {
    private val model:MainViewModelImpl by viewModels()
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            model.getAllPosts()

            lifecycleScope.launch {
                model.postsLivedata.observe(this@MainActivity){
                    when(it){
                        is Resource.Error -> {
                            it.throwable
                            Log.d(TAG, "onCreate: ${it.throwable.message}")
                        }
                        Resource.Loading -> {
                            it
                        }
                        is Resource.Success -> {
                            it.data
                            Log.d(TAG, "onCreate: ${it.data}")
                        }
                    }
                }
            }

        }
    }
}

