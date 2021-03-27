package com.bytestore.app.repository

import com.bytestore.app.network.model.Articles
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {
    suspend fun getArticles(): Flow<Articles>
}