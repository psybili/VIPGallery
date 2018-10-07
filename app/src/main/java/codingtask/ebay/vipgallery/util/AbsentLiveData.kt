package codingtask.ebay.vipgallery.util

import android.arch.lifecycle.LiveData

// To represent empty LiveData instances
class AbsentLiveData<T> private constructor() : LiveData<T>() {
    init {
        postValue(null)
    }

    companion object {
        fun <T> create(): LiveData<T> {
            return AbsentLiveData()
        }
    }
}
