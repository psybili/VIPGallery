package codingtask.ebay.vipgallery.ui.gallery

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import codingtask.ebay.vipgallery.data.model.VIP
import codingtask.ebay.vipgallery.data.repository.VIPRepository
import codingtask.ebay.vipgallery.util.AbsentLiveData
import codingtask.ebay.vipgallery.util.ApiResponse
import codingtask.ebay.vipgallery.util.switchMap
import javax.inject.Inject

class GalleryViewModel @Inject constructor(
        private val galleryRepository: VIPRepository
) : ViewModel() {

    val vipUrl = MutableLiveData<String>()

    val apiResponse: LiveData<ApiResponse<VIP>>

    init {
        apiResponse = vipUrl.switchMap { url ->
            when (url) {
                null -> AbsentLiveData.create()
                else -> galleryRepository.updateVIP(url)
            }
        }
    }
}


