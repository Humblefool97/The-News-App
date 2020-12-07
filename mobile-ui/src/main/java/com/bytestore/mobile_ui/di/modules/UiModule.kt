package com.bytestore.mobile_ui.di.modules

import com.bytestore.mobile_ui.ui.HomeActivity
import com.bytestore.mobile_ui.ui.NewsDetailsFragment
import com.bytestore.mobile_ui.ui.NewsListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {
    @ContributesAndroidInjector
    abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    abstract fun bindNewsListFragment(): NewsListFragment

    @ContributesAndroidInjector
    abstract fun bindDetailsFragment(): NewsDetailsFragment
}