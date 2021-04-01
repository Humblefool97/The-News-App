package com.bytestore.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bytestore.app.Article
import com.bytestore.app.repository.ArticlesRepository
import com.bytestore.app.state.Resource
import com.bytestore.app.state.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    val repository: ArticlesRepository,
) : ViewModel() {
    private val liveData: MutableLiveData<Resource<PagingData<Article>>> = MutableLiveData()
    val articleLiveData: LiveData<Resource<PagingData<Article>>>
        get() = liveData
    private var job: Job? = null

    init {
        fetchArticles()
    }

    private val getArticlesExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
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
        val scope = viewModelScope

        job = scope.launch() {
            val newPagingData = repository.getArticles()
            newPagingData.cachedIn(viewModelScope)
            newPagingData.collectLatest {
                liveData.postValue(
                    Resource(
                        state = ResourceState.SUCCESS,
                        data = it,
                        null
                    )
                )
            }
        }
    }
}