package com.bytestore.mobile_ui.di

import android.app.Application
import com.bytestore.mobile_ui.NewsApplication
import com.bytestore.mobile_ui.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        AppModule::class,
        UiModule::class,
        PresentationModule::class,
        DataModule::class,
        RemoteModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: NewsApplication)
}