package com.bytestore.domain.repository

import com.bytestore.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {
    fun getArticles():Flow<List<Article>>
}