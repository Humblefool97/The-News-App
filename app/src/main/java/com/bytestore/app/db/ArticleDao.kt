package com.bytestore.app.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.bytestore.app.Article
import com.bytestore.app.Source
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Insert
    public abstract fun insertArticle(article: ArticleEntity): Long

    @Insert
    public abstract fun insertSource(source: SourceEntity)

    @Transaction
    @Query("SELECT * from ArticleEntity")
    public abstract fun getArticlesWithEntity(): Flow<List<ArticleAndSourceEntity>>
    /**
     * Insert Articles along with thier sources
     * //TODO: Take care of transactions
     */
    public fun insertArticlesWithSource(articles: List<Article>) {
        //in a loop
        articles.forEach { article ->
            //Convert Articles in to ArticleEntity First
            val articleEntity = ArticleEntity(
                articleId = 0,
                author = article.author,
                title = article.title,
                description = article.description,
                url = article.url,
                urlToImage = article.urlToImage,
                publishedAt = article.publishedAt,
                content = article.content
            )
            // Add the article entity
            val articleId = insertArticle(articleEntity)
            // Get the id after adding, create SourceEntity
            val source = SourceEntity(
                id = 0,
                articleOwnerId = articleId,
                name = article.source?.name
            )
            //Add SourceEntity
            insertSource(source)
        }
    }
}