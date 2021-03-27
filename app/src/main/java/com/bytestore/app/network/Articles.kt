package com.bytestore.app.network

import com.bytestore.app.Article
import com.google.gson.annotations.SerializedName

/**
 * The [Article] list from the remote
 * response
 */

data class Articles(
    @SerializedName("articles")
    val articles: List<Article> = emptyList()
)
