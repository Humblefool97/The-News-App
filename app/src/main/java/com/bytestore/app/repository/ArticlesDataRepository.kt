package com.bytestore.app.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.bytestore.app.Article
import com.bytestore.app.localdata.LocalDataSource
import com.bytestore.app.network.model.Articles
import com.bytestore.app.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticlesDataRepository @Inject constructor(
    val remoteDataSource: RemoteDataSource,
    val localDataSource: LocalDataSource,
) : ArticlesRepository {

    override suspend fun getArticles(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(
                pageSize = ArticlePagingSource.INITIAL_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                ArticlePagingSource(
                    topic = "COVID",
                    remoteDataSource = remoteDataSource
                )
            }
        ).flow
    }
}