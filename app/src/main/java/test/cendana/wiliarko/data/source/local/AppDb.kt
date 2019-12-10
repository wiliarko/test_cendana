package test.cendana.wiliarko.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import test.cendana.wiliarko.data.model.UserDBModel
import test.cendana.wiliarko.data.source.local.dao.UserDao

@Database(entities = [UserDBModel::class], version = 1, exportSchema = false)
abstract class AppDb: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private const val DB_NAME = "testCendana2000"
        private var dbInstance: AppDb? = null

        fun getDatabase(context: Context): AppDb {
            if(dbInstance == null) {
                dbInstance = Room
                    .databaseBuilder(context.applicationContext, AppDb::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .build()
            }
            return dbInstance as AppDb
        }
    }
}