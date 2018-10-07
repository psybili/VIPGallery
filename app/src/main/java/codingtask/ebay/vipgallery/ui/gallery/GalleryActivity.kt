package codingtask.ebay.vipgallery.ui.gallery

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import codingtask.ebay.vipgallery.R
import codingtask.ebay.vipgallery.util.setContentFragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class GalleryActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gallery_activity)
        setContentFragment(R.id.galleryContainerLayout) { GalleryFragment.newInstance() }
    }
}
