package com.bytestore.remote.service

import com.bytestore.remote.model.ArticleResponseModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {
    @GET("everything/")
    suspend fun getArticles(
        @Query("q") topic: String,
        @Query("apiKey") apiKey: String
    ): ArticleResponseModel
}