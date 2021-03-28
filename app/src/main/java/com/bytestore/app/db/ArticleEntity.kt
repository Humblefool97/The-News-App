package com.bytestore.app.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "articleId")
    val articleId: Long,

    var author: String?,
    var title: String?,
    var description: String?,
    var url: String?,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?
)

@Entity
data class SourceEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "source_id")
    val id: Long,
    val name: String?,
    val articleOwnerId: Long
)