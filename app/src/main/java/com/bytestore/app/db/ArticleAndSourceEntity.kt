package com.bytestore.app.db

import androidx.room.Embedded
import androidx.room.Relation

data class ArticleAndSourceEntity(
    @Embedded val articleEntity: ArticleEntity,
    @Relation(
        parentColumn = "articleId",
        entityColumn = "articleOwnerId",
        entity = SourceEntity::class
    )
    val source: SourceEntity
)
