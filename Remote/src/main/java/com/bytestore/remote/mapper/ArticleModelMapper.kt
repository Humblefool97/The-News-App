package com.bytestore.remote.mapper

import com.bytestore.data.model.ArticleEntity
import com.bytestore.data.model.SourceEntity
import com.bytestore.remote.model.ArticleModel

class ArticleModelMapper : ModelMapper<ArticleModel, ArticleEntity> {
    override fun mapFromModel(model: ArticleModel): ArticleEntity {
        return ArticleEntity(
            source = SourceEntity(model.source.id, model.source.name),
            author = model.author,
            title = model.title,
            description = model.description,
            url = model.url,
            urlToImage = model.urlToImage,
            publishedAt = model.publishedAt,
            content = model.content
        )
    }
}