package com.bytestore.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bytestore.domain.interactor.GetArticlesUseCase
import com.bytestore.presentation.mapper.ArticleViewMapper
import com.bytestore.presentation.model.ArticlesView
import com.bytestore.presentation.state.Resource
import com.bytestore.presentation.state.ResourceState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArticlesViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase?,
    private val articleViewMapper: ArticleViewMapper
) : ViewModel() {

    private val liveData: MutableLiveData<Resource<List<ArticlesView>>> = MutableLiveData()

    init {
        fetchArticles()
    }

    fun fetchArticles() {
        viewModelScope.launch(Dispatchers.Default) {
            getArticlesUseCase?.invoke()?.map {
                it.map { article ->
                    articleViewMapper.fromDomainToView(article)
                }
            }?.catch {
                liveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        null,
                        "Couldn't fetch articles!!"
                    )
                )
            }?.collect {
                liveData.postValue(
                    Resource(
                        ResourceState.SUCCESS,
                        it,
                        null
                    )
                )
            }
        }
    }
}