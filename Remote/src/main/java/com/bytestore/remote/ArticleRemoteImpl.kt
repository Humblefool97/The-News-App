package com.bytestore.remote

import com.bytestore.data.model.ArticleEntity
import com.bytestore.data.repository.ArticlesRemote
import com.bytestore.remote.mapper.ArticleModelMapper
import com.bytestore.remote.service.Endpoint
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticleRemoteImpl @Inject constructor(
        private val modelMapper: ArticleModelMapper,
        private val backgroundDispatcher: CoroutineDispatcher,
        private val endpoint: Endpoint
) : ArticlesRemote {

    override suspend fun getArticles(): Flow<List<ArticleEntity>> =
            withContext(backgroundDispatcher) {
                flow {
                    val articleEntityList = endpoint.getArticles(
                            topic = "Android",
                            apiKey = "d9b56c355a4c48a0bf69059b41297144"
                    ).articleList.map {
                        modelMapper.mapFromModel(it)
                    }
                    emit(articleEntityList)
                }
            }
}