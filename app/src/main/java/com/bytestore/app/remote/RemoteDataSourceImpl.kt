package com.bytestore.app.remote

import android.util.Log
import com.bytestore.app.BuildConfig
import com.bytestore.app.network.RetrofitApiService
import com.bytestore.app.network.model.Articles
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val retrofitApiService: RetrofitApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : RemoteDataSource {

    override suspend fun getArticles(topic: String, pageSize: Int): Articles =
        withContext(dispatcher) {

            val articles =
                retrofitApiService.getTopHeadlines(
                    topic = topic,
                    pageSize = pageSize,
                    apiKey = BuildConfig.API_KEY
                )
            Log.d("NewsApp","News item obtained ${articles.articles.size}")
            articles
        }
}
