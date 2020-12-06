package com.bytestore.data.store

import com.bytestore.data.repository.ProjectsDataStore
import javax.inject.Inject

/**
 * Single source truth for the layer above this.
 * Provide [ProjectRemoteDataStore] / CacheDataStore
 * based on data availability
 */
class ProjectDataStoreProvider @Inject constructor(
    private val projectRemoteDataStore: ProjectRemoteDataStore
) {
     fun getDataSore(
        projectCached: Boolean,
        projectsCachedExpired: Boolean
    ): ProjectsDataStore {
        //TODO:For now  return remote data store
        return projectRemoteDataStore
    }
}