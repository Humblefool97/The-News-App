package com.bytestore.presentation.mapper

import com.bytestore.domain.model.Article
import com.bytestore.presentation.model.ArticlesView
import com.bytestore.presentation.model.Source

class ArticleViewMapper : ViewMapper<ArticlesView, Article> {
    override fun fromDomainToView(type: Article): ArticlesView {
        return ArticlesView(
            source = Source(type.source.id, type.source.name),
            author = type.author,
            title = type.title,
            description = type.description,
            url = type.url,
            urlToImage = type.urlToImage,
            publishedAt = type.publishedAt,
            content = type.content
        )
    }
}