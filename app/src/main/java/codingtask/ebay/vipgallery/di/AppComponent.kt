package codingtask.ebay.vipgallery.di

import codingtask.ebay.vipgallery.App
import codingtask.ebay.vipgallery.di.module.DataModule
import codingtask.ebay.vipgallery.di.module.UiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Application level component for modules
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    DataModule::class,
    UiModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun dataModule(dataModule: DataModule): Builder

        fun build(): AppComponent
    }

    override fun inject(app: App)
}