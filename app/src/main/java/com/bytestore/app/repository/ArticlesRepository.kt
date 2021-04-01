package com.bytestore.app.repository

import androidx.paging.PagingData
import com.bytestore.app.Article
import com.bytestore.app.network.model.Articles
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {
    suspend fun getArticles(): Flow<PagingData<Article>>
}