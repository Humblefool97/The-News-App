package com.bytestore.app.di

import com.bytestore.app.repository.ArticlesDataRepository
import com.bytestore.app.repository.ArticlesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideArticlesRepository(articlesDataRepository: ArticlesDataRepository):ArticlesRepository
}