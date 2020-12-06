package com.bytestore.remote.model

import com.google.gson.annotations.SerializedName

class ArticleResponseModel(
    @SerializedName("articles")
    val articleList: List<ArticleModel>
)