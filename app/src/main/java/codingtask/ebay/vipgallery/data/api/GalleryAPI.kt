package codingtask.ebay.vipgallery.data.api

import android.arch.lifecycle.LiveData
import codingtask.ebay.vipgallery.data.model.VIP
import codingtask.ebay.vipgallery.util.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Remote service interface
 */
interface GalleryAPI {

    // Returns the new gallery api response from remote server as Single
    @GET("{vipUrl}")
    fun getVIP(@Path(value = "vipUrl") vipUrl: String): LiveData<ApiResponse<VIP>>

}