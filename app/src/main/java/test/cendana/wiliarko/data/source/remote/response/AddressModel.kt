package test.cendana.wiliarko.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import test.cendana.wiliarko.data.source.remote.response.GeoModel

@Parcelize
data class AddressModel(
    @SerializedName("street")
    open var street: String? = null,

    @SerializedName("suite")
    open var suite: String? = null,

    @SerializedName("city")
    open var city: String? = null,

    @SerializedName("zipcode")
    open var zipcode: String? = null,

    @SerializedName("geo")
    open var geo: GeoModel? = null

): Parcelable