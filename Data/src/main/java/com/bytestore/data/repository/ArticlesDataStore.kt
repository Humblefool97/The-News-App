package com.bytestore.data.repository

import com.bytestore.data.model.ArticleEntity
import kotlinx.coroutines.flow.Flow

interface ArticlesDataStore {
    fun getArticles(): Flow<List<ArticleEntity>>
}