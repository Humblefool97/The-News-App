package com.bytestore.data.store

import com.bytestore.data.repository.ArticlesDataStore
import javax.inject.Inject

/**
 *
 * Provide [ArticleRemoteDataStore] / CacheDataStore
 * based on data availability
 */
class ArticlesDataStoreProvider @Inject constructor(
    private val articleRemoteDataStore: ArticleRemoteDataStore
) {
     fun getDataSore(
        projectCached: Boolean,
        projectsCachedExpired: Boolean
    ): ArticlesDataStore {
        //TODO:For now  return remote data store
        return articleRemoteDataStore
    }
}