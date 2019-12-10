package test.cendana.wiliarko.data.model

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel(
    @SerializedName("id")
    open var id: String? = null,

    @SerializedName("name")
    open var name: String? = null,

    @SerializedName("username")
    open var username: String? = null,

    @SerializedName("email")
    open var email: String? = null,

    @SerializedName("address")
    open var address: AddressModel? = null

): Parcelable