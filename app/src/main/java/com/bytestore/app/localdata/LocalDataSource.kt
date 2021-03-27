package com.bytestore.app.localdata

import com.bytestore.app.network.model.Articles
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun saveArticlesToDb(articles: Articles)

   // suspend fun getArticles(): Flow<Articles>
}