package com.bytestore.data.store

import com.bytestore.data.model.ArticleEntity
import com.bytestore.data.repository.ArticlesDataStore
import com.bytestore.data.repository.ArticlesRemote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 *
 */
class ArticleRemoteDataStore @Inject constructor(val articlesRemote: ArticlesRemote) :
    ArticlesDataStore {
    override suspend fun getArticles(): Flow<List<ArticleEntity>> {
        return articlesRemote.getArticles()
    }
}