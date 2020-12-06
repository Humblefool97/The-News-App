package com.bytestore.data.model

data class ArticleEntity(
    var source: SourceEntity,
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var publishedAt: String,
    var content: String
)

data class SourceEntity(
    var id: String,
    var name: String
)