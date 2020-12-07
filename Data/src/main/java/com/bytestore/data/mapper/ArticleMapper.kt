package com.bytestore.data.mapper

import com.bytestore.data.model.ArticleEntity
import com.bytestore.data.model.SourceEntity
import com.bytestore.domain.model.Article
import com.bytestore.domain.model.Source
import javax.inject.Inject

class ArticleMapper @Inject constructor() : EntityMapper<ArticleEntity, Article> {
    override fun mapFromEntity(entity: ArticleEntity): Article {
        return Article(
            source = Source(entity.source?.id, entity.source?.name),
            author = entity.author,
            title = entity.title,
            description = entity.description,
            url = entity.url,
            urlToImage = entity.urlToImage,
            publishedAt = entity.publishedAt,
            content = entity.content
        )
    }

    override fun mapToEntity(data: Article): ArticleEntity {
      return ArticleEntity(
          source = SourceEntity(data.source?.id, data.source?.name),
          author = data.author,
          title = data.title,
          description = data.description,
          url = data.url,
          urlToImage = data.urlToImage,
          publishedAt = data.publishedAt,
          content = data.content
      )
    }
}