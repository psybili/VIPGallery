package codingtask.ebay.vipgallery.di.module

import android.arch.lifecycle.ViewModelProvider
import codingtask.ebay.vipgallery.ui.gallery.GalleryActivity
import codingtask.ebay.vipgallery.di.ViewModelFactory
import codingtask.ebay.vipgallery.ui.detail.DetailActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Module for activities
 */
@Module
internal abstract class UiModule {

  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

  @ContributesAndroidInjector(modules = [GalleryModule::class])
  internal abstract fun contributeGalleryActivity(): GalleryActivity

  @ContributesAndroidInjector(modules = [GalleryModule::class])
  internal abstract fun contributeDetailActivity(): DetailActivity

}