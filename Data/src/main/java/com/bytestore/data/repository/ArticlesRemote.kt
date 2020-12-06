package com.bytestore.data.repository

import com.bytestore.data.model.ArticleEntity
import kotlinx.coroutines.flow.Flow

interface ArticlesRemote {
    fun getArticles():Flow<List<ArticleEntity>>
}