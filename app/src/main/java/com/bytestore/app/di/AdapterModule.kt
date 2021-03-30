package com.bytestore.app.di

import com.bytestore.app.Article
import com.bytestore.app.ui.adapter.NewsListRecyclerViewAdapters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class AdapterModule {

    @Provides
    fun provideArticleList(): List<Article> = emptyList<Article>()

    @Provides
    fun provideNewsListAdapter(list: List<Article>): NewsListRecyclerViewAdapters {
        return NewsListRecyclerViewAdapters(list)
    }
}