package com.bytestore.mobile_ui.mapper

import com.bytestore.mobile_ui.model.Article
import com.bytestore.mobile_ui.model.Source
import com.bytestore.presentation.model.ArticlesView
import javax.inject.Inject

class ArticleUiViewMapper @Inject constructor() : Mapper<ArticlesView, Article> {
    override fun mapFromPresentation(presentation: ArticlesView): Article {
        return Article(
            source = Source(presentation.source?.id, presentation.source?.name),
            author = presentation.author,
            title = presentation.title,
            description = presentation.description,
            url = presentation.url,
            urlToImage = presentation.urlToImage,
            publishedAt = presentation.publishedAt,
            content = presentation.content
        )
    }
}