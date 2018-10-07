package codingtask.ebay.vipgallery

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import codingtask.ebay.vipgallery.CustomAssertions.Companion.hasItemCount
import codingtask.ebay.vipgallery.ui.gallery.GalleryActivity
import org.junit.Rule
import org.junit.Test

class GalleryActivityTests {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<GalleryActivity>(GalleryActivity::class.java)

    @Test
    fun testListImages() {
        Thread.sleep(1500)
        onView(withId(R.id.galleryRecyclerView))
                .perform()
                .check(hasItemCount(10))
    }

}