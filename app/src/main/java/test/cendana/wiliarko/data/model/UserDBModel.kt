package test.cendana.wiliarko.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName =  "User")
data class UserDBModel(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    open var id: Int? = null,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    open var name: String? = null,

    @ColumnInfo(name = "username")
    @SerializedName("username")
    open var username: String? = null,

    @ColumnInfo(name = "email")
    @SerializedName("email")
    open var email: String? = null,

    @ColumnInfo(name = "street")
    @SerializedName("street")
    open var street: String? = null,

    @ColumnInfo(name = "suite")
    @SerializedName("suite")
    open var suite: String? = null,

    @ColumnInfo(name = "city")
    @SerializedName("city")
    open var city: String? = null,

    @ColumnInfo(name = "zipcode")
    @SerializedName("zipcode")
    open var zipcode: String? = null,

    @ColumnInfo(name = "lat")
    @SerializedName("lat")
    open var lat: String? = null,

    @ColumnInfo(name = "lng")
    @SerializedName("lng")
    open var lng: String? = null

): Parcelable