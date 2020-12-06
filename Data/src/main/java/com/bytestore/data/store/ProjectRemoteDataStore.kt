package com.bytestore.data.store

import com.bytestore.data.model.ArticleEntity
import com.bytestore.data.repository.ProjectsDataStore
import com.bytestore.data.repository.ProjectsRemote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 *
 */
class ProjectRemoteDataStore @Inject constructor(val projectsRemote: ProjectsRemote) :
    ProjectsDataStore {
    override fun getArticles(): Flow<List<ArticleEntity>> {
        return projectsRemote.getArticles()
    }
}