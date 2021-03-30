package com.bytestore.app.di

import android.content.Context
import com.bytestore.app.db.AppDatabase
import com.bytestore.app.db.ArticleDao
import com.bytestore.app.localdata.LocalDataSource
import com.bytestore.app.localdata.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataModule {
    companion object {

        @Provides
        @JvmStatic
        @Singleton
        fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
            return AppDatabase.getInstance(appContext)
        }

        @Provides
        @JvmStatic
        fun provideAppDao(appDatabase: AppDatabase): ArticleDao {
            return appDatabase.getArticlesDao()
        }
    }

    @Singleton
    @Binds
    abstract fun provideLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource
}