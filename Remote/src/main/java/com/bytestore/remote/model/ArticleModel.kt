package com.bytestore.remote.model

import com.google.gson.annotations.SerializedName

data class ArticleModel(
    @SerializedName("id") var source: SourceModel?,
    @SerializedName("author") var author: String?,
    @SerializedName("title") var title: String,
    @SerializedName("description") var description: String,
    @SerializedName("url") var url: String,
    @SerializedName("urlToImage") var urlToImage: String?,
    @SerializedName("publishedAt") var publishedAt: String,
    @SerializedName("content") var content: String?
)

data class SourceModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)