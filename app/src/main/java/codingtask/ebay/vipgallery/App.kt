package codingtask.ebay.vipgallery

import codingtask.ebay.vipgallery.di.DaggerAppComponent
import codingtask.ebay.vipgallery.di.applyAutoInjector
import codingtask.ebay.vipgallery.di.module.DataModule
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder()
            .application(this)
            .dataModule(DataModule(this))
            .build()

    override fun onCreate() {
        super.onCreate()
        applyAutoInjector()
    }

}
