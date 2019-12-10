package test.cendana.wiliarko.data.source.remote

import retrofit2.Call
import retrofit2.http.GET
import test.cendana.wiliarko.data.source.remote.response.UsersResponse

interface ApiInterface {

    @GET("users")
    fun users(): Call<UsersResponse>

}