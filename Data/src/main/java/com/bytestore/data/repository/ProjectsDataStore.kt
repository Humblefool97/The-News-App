package com.bytestore.data.repository

import com.bytestore.data.model.ArticleEntity
import kotlinx.coroutines.flow.Flow

interface ProjectsDataStore {
    fun getArticles(): Flow<List<ArticleEntity>>
}