package com.bytestore.mobile_ui.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    abstract  fun bindsContext(application: Application):Context
}