package com.bytestore.app.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bytestore.app.Article
import com.bytestore.app.BuildConfig
import com.bytestore.app.network.RetrofitApiService
import retrofit2.HttpException
import java.io.IOException

private const val KEY_FIRST_PAGE = 1

class ArticlePagingSource(
    private val service: RetrofitApiService,
    private val topic: String
) : PagingSource<Int, Article>() {

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        //Since first time call it has null value,provide the index as 1
        val pageKey = params.key ?: KEY_FIRST_PAGE
        val size = params.loadSize
        return try {
            val items = service.getTopHeadlines(
                topic = topic,
                pageSize = size,
                apiKey = BuildConfig.API_KEY
            )
            val nextKey = if (items.articles.isEmpty()) null else {
                pageKey + (params.loadSize / INITIAL_PAGE_SIZE)
            }

            LoadResult.Page(
                data = items.articles,
                nextKey = nextKey,
                prevKey = if (pageKey == KEY_FIRST_PAGE) null else pageKey - 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    companion object {
        val INITIAL_PAGE_SIZE = 50
    }

}