package com.bytestore.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import javax.inject.Inject

@Database(entities = [ArticleEntity::class, SourceEntity::class], version = 1)
abstract class AppDatabase @Inject constructor() : RoomDatabase() {
    abstract fun getArticlesDao(): ArticleDao

    companion object {
        private val appDbName = "appDb"

        @Volatile
        private var appDatabaseInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return appDatabaseInstance ?: synchronized(this) {
                appDatabaseInstance ?: getAppDatabase(context).also {
                    appDatabaseInstance = it
                }
            }
        }

        private fun getAppDatabase(context: Context): AppDatabase {
            return Room
                .databaseBuilder(context, AppDatabase::class.java, appDbName)
                .build()
        }
    }
}