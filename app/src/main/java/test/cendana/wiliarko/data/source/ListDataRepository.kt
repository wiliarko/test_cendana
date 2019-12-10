package test.cendana.wiliarko.data.source

import androidx.lifecycle.LiveData
import test.cendana.wiliarko.data.model.UserDBModel
import test.cendana.wiliarko.data.source.remote.response.UserModel
import test.cendana.wiliarko.data.source.local.LocalRepository
import test.cendana.wiliarko.data.source.remote.RemoteRepository

class ListDataRepository(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
): ListDataSource {

    companion object {
        fun getInstance(remoteRepository: RemoteRepository, localRepository: LocalRepository): ListDataRepository {
            return ListDataRepository(remoteRepository, localRepository)
        }
    }

    override fun getUsersDB(): LiveData<List<UserDBModel>> {
        return localRepository.getAllUser()
    }

    override fun add(user: UserDBModel) {
        localRepository.add(user)
    }

    override fun getUsersRemote(): LiveData<List<UserModel>> {
        return remoteRepository.getUsers()
    }


}