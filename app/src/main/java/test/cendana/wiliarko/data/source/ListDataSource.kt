package test.cendana.wiliarko.data.source

import androidx.lifecycle.LiveData
import test.cendana.wiliarko.data.model.UserDBModel
import test.cendana.wiliarko.data.model.UserModel

interface ListDataSource {

    fun getUsersDB(): LiveData<List<UserDBModel>>

    fun add(user: UserDBModel)

    fun getUsersRemote(): LiveData<List<UserModel>>
}