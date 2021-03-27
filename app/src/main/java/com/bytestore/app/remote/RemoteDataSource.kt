package com.bytestore.app.remote

import com.bytestore.app.network.model.Articles
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getArticles(topic: String, pageSize: Int): Flow<Articles>
}