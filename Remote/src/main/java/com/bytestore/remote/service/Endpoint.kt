package com.bytestore.remote.service

import com.bytestore.remote.model.ArticleResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {
    @GET("everything/")
    suspend fun getArticles(
        @Query("q") topic: String,
        @Query("pageSize") pageSize: Int = 40,
        @Query("apiKey") apiKey: String
    ): ArticleResponseModel
}