package com.bytestore.data

import com.bytestore.data.mapper.ArticleMapper
import com.bytestore.data.store.ArticlesDataStoreProvider
import com.bytestore.domain.model.Article
import com.bytestore.domain.repository.ArticlesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ArticlesDataRepository @Inject constructor(
        private val articleMapper: ArticleMapper,
        private val provider: ArticlesDataStoreProvider
) : ArticlesRepository {

    override suspend fun getArticles(): Flow<List<Article>> {
        return flow {
            val articleListFlow = provider.getDataSore(false, true)
                    .getArticles()
            articleListFlow.collect {
                val articleListEntity =
                        it.map { articleEntity ->
                            articleMapper.mapFromEntity(articleEntity)
                        }
                emit(articleListEntity)
            }
        }
    }
}