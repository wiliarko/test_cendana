package test.cendana.wiliarko.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import test.cendana.wiliarko.data.model.UserDBModel

@Dao
interface UserDao {
    @get:Query("SELECT * FROM User")
    val all: LiveData<List<UserDBModel>>

    @Query("SELECT * FROM User WHERE id = :id")
    fun getById(id: Int?): UserDBModel?

    @Query("SELECT * FROM User WHERE name like '%' || :src || '%'")
    fun srcByName(src: String?): UserDBModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserDBModel): Long

    @Update
    fun update(user: UserDBModel): Int
}