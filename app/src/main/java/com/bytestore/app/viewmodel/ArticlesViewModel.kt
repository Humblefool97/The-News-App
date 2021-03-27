package com.bytestore.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bytestore.app.Article
import com.bytestore.app.repository.ArticlesRepository
import com.bytestore.app.state.Resource
import com.bytestore.app.state.ResourceState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArticlesViewModel @Inject constructor(val repository: ArticlesRepository) : ViewModel() {
    private val liveData: MutableLiveData<Resource<List<Article>>> = MutableLiveData()
    val articleLiveData: LiveData<Resource<List<Article>>>
        get() = liveData
    private var job: Job? = null

    init {
        fetchArticles()
    }

    val getArticlesExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        liveData.postValue(
            Resource(
                ResourceState.ERROR,
                null,
                "Something went wrong .Please try again!"
            )
        )
    }

    fun fetchArticles() {
        job?.cancel()

        liveData.value = Resource(ResourceState.LOADING, null, null)
        job = viewModelScope.launch(getArticlesExceptionHandler) {
            repository
                .getArticles()
                .collect {
                    liveData.postValue(Resource(ResourceState.SUCCESS, it.articles, null))
                }
        }
    }
}