package test.cendana.wiliarko.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import test.cendana.wiliarko.data.model.UserDBModel
import test.cendana.wiliarko.data.model.UserModel
import test.cendana.wiliarko.data.source.ListDataRepository

class SplashcreenViewmodel(private val listDataRepository: ListDataRepository): ViewModel() {

    fun getUser(): LiveData<List<UserModel>> {
        return listDataRepository.getUsersRemote()
    }

    fun saveUser(user:UserDBModel){
        listDataRepository.add(user)
    }
}