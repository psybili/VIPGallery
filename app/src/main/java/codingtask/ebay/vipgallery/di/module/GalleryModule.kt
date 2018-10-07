package codingtask.ebay.vipgallery.di.module

import android.arch.lifecycle.ViewModel
import codingtask.ebay.vipgallery.di.ViewModelKey
import codingtask.ebay.vipgallery.ui.detail.DetailFragment
import codingtask.ebay.vipgallery.ui.gallery.GalleryFragment
import codingtask.ebay.vipgallery.ui.gallery.GalleryViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * ViewModel module
 */
@Module
internal abstract class GalleryModule {

    @Binds
    @IntoMap
    @ViewModelKey(GalleryViewModel::class)
    abstract fun bindGalleryViewModel(viewModel: GalleryViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributeGalleryFragment(): GalleryFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailFragment(): DetailFragment

}