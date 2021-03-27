package com.bytestore.app.network

import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface RetrofitApiService {

    suspend fun getTopHeadlines(
        @Query("q") topic: String,
        @Query("pageSize") pageSize: Int = 40,
        @Query("apiKey") apiKey: String
    ): Flow<Articles>
}