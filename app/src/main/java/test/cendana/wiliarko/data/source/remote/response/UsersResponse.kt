package test.cendana.wiliarko.data.source.remote.response

import com.google.gson.annotations.SerializedName
import test.cendana.wiliarko.data.model.UserModel

data class UsersResponse(
    @SerializedName("results")
    val results: MutableList<UserModel>
)