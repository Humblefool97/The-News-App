package com.bytestore.mobile_ui.di.modules

import com.bytestore.data.repository.ArticlesRemote
import com.bytestore.mobile_ui.BuildConfig
import com.bytestore.remote.ArticleRemoteImpl
import com.bytestore.remote.mapper.ArticleModelMapper
import com.bytestore.remote.service.Endpoint
import com.bytestore.remote.service.RetrofitProvider
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

@Module
abstract class RemoteModule {
    val ioDispatcher = Dispatchers.IO

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideApiService(): Endpoint {
            return RetrofitProvider.provideRetrofitEndPoint(BuildConfig.DEBUG)
        }

        @Provides
        @JvmStatic
        fun provideArticleRemote(
            modelMapper: ArticleModelMapper,
            apiService: Endpoint
        ): ArticlesRemote {
            return ArticleRemoteImpl(
                modelMapper,
                Dispatchers.IO,
                apiService
            )
        }
    }
}