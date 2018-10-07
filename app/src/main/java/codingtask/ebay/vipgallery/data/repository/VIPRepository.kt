package codingtask.ebay.vipgallery.data.repository

import codingtask.ebay.vipgallery.data.api.GalleryAPI
import javax.inject.Inject

/**
 * Repository for the image gallery
 */
class VIPRepository @Inject constructor(
        private val vipapi: GalleryAPI) {

    fun updateVIP(vipUrl: String) = vipapi.getVIP(vipUrl)

}
