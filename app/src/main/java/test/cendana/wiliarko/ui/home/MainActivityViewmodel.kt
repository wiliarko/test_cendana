package test.cendana.wiliarko.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import test.cendana.wiliarko.data.model.UserDBModel
import test.cendana.wiliarko.data.source.ListDataRepository

class MainActivityViewmodel(private val listDataRepository: ListDataRepository): ViewModel() {
    fun getUser(): LiveData<List<UserDBModel>> {
        return listDataRepository.getUsersDB()
    }
}