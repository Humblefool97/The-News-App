package com.bytestore.app.network

import com.bytestore.app.network.model.Articles
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface RetrofitApiService {

    suspend fun getTopHeadlines(
        @Query("q") topic: String,
        @Query("pageSize") pageSize: Int = 40,
        @Query("apiKey") apiKey: String
    ): Articles
}