package test.cendana.wiliarko.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GeoModel(
    @SerializedName("lat")
    open var lat: String? = null,

    @SerializedName("lng")
    open var lng: String? = null

): Parcelable