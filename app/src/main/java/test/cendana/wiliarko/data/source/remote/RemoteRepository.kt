package test.cendana.wiliarko.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.cendana.wiliarko.data.model.UserModel
import test.cendana.wiliarko.data.source.remote.response.UsersResponse

const val TAG = "LogRemoteRepository"
class RemoteRepository {
    private val apiClient = Api.getClient().create(ApiInterface::class.java)

    companion object {
        fun getInstance(): RemoteRepository {
            return RemoteRepository()
        }
    }

    fun getUsers(): LiveData<List<UserModel>> {
        val users: MutableLiveData<List<UserModel>> = MutableLiveData()

        apiClient.users().enqueue(
            object : Callback<UsersResponse> {
                override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                    Log.d(TAG, t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<UsersResponse>,
                    response: Response<UsersResponse>
                ) {
                    response.body()?.let { users.postValue(it.results) }
                }

            }
        )
        return users
    }
}