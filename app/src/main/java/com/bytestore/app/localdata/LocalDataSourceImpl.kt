package com.bytestore.app.localdata

import com.bytestore.app.db.ArticleDao
import com.bytestore.app.network.model.Articles
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    val articleDao: ArticleDao
) : LocalDataSource {

    override suspend fun saveArticlesToDb(articles: Articles) {
       articleDao.insertArticlesWithSource(articles.articles)
    }
}