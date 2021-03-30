package com.bytestore.app.di

import com.bytestore.app.BuildConfig
import com.bytestore.app.network.RetrofitApiService
import com.bytestore.app.network.RetrofitProvider
import com.bytestore.app.remote.RemoteDataSource
import com.bytestore.app.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    companion object {
        @Provides
        @JvmStatic
        fun provideApiService(): RetrofitApiService {
            return RetrofitProvider.provideRetrofitProvider(BuildConfig.DEBUG)
        }

        @Provides
        @JvmStatic
        fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO
    }

    @Binds
    abstract fun provideGetRemoteDataSource(remoteDataSource: RemoteDataSourceImpl): RemoteDataSource
}