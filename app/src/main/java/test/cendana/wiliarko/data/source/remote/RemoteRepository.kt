package test.cendana.wiliarko.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.cendana.wiliarko.data.source.remote.response.UserModel

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
            object : Callback<List<UserModel>> {
                override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
                    Log.d(TAG, t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<List<UserModel>>,
                    response: Response<List<UserModel>>
                ) {
                    response.body()?.let { users.postValue(it) }
                }

            }
        )
        return users
    }
}