package com.bytestore.mobile_ui.di.modules

import com.bytestore.data.ArticlesDataRepository
import com.bytestore.domain.repository.ArticlesRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(articlesDataRepository: ArticlesDataRepository):ArticlesRepository

}