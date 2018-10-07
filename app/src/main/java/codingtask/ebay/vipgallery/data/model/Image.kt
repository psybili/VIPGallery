package codingtask.ebay.vipgallery.data.model

import android.databinding.BaseObservable
import com.google.gson.annotations.SerializedName

data class Image(
        @SerializedName("uri")
        val uri: String,
        @SerializedName("set")
        val set: String
) : BaseObservable() {
    fun getThumbUri() = "https://${uri}_2.jpg"
    fun getBigUri() = "https://${uri}_27.jpg"
}