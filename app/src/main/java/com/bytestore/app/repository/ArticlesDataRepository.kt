package com.bytestore.app.repository

import com.bytestore.app.localdata.LocalDataSource
import com.bytestore.app.network.model.Articles
import com.bytestore.app.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow

class ArticlesDataRepository(
    val remoteDataSource: RemoteDataSource,
    val localDataSource: LocalDataSource,
) : ArticlesRepository {
    override suspend fun getArticles(): Flow<Articles> {
        return remoteDataSource.getArticles(
            "COVID",
            pageSize = 50
        )
    }
}