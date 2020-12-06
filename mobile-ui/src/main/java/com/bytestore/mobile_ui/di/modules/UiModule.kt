package com.bytestore.mobile_ui.di.modules

import com.bytestore.mobile_ui.ui.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {
    @ContributesAndroidInjector
    abstract fun bindHomeActivity(): HomeActivity
}