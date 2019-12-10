package test.cendana.wiliarko.data.source.local

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import test.cendana.wiliarko.data.model.UserDBModel
import test.cendana.wiliarko.data.source.local.dao.UserDao

class LocalRepository(context: Context) {

    private val userDao: UserDao

    init {
        val db = AppDb.getDatabase(context)
        userDao = db.userDao()
    }

    companion object {
        fun getInstance(context: Context): LocalRepository {
            return LocalRepository(context)
        }
    }

    fun getAllUser(): LiveData<List<UserDBModel>> {
        return userDao.all
    }

    fun addUser(user: UserDBModel) {
        GlobalScope.launch(Dispatchers.Main) { userDao.insert(user) }
    }


    fun updateUser(user: UserDBModel) {
        GlobalScope.launch(Dispatchers.Main) { userDao.insert(user) }
    }

    fun add(user: UserDBModel) {
        if(userDao.getById(user.id)!=null){
            updateUser(user)
        }else{
            addUser(user)
        }
    }
}