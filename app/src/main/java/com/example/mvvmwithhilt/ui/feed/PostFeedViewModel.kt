package com.example.mvvmwithhilt.ui.feed

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmwithhilt.Courotines
import com.example.mvvmwithhilt.models.PostModel
import com.example.mvvmwithhilt.repositories.PostRepositories
import kotlinx.coroutines.Job
import javax.inject.Inject

class PostFeedViewModel @ViewModelInject constructor(val postRepo:PostRepositories) : ViewModel() {
    private val _posts = MutableLiveData<List<PostModel>>()
    val loadingPost = MutableLiveData<Boolean>(false)
    private lateinit var job: Job
    val posts : LiveData<List<PostModel>>  get() = _posts

    fun getPosts(){
        job = Courotines.ioThenMain(
            {
                loadingPost.postValue(true)
                postRepo.getPosts()
            },{
                _posts.value=it;
                loadingPost.postValue(false)
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized){
            job.cancel()
        }
    }
}