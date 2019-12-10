package test.cendana.wiliarko.ui.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import test.cendana.wiliarko.data.source.ListDataRepository
import test.cendana.wiliarko.di.Injection
import test.cendana.wiliarko.ui.SplashcreenViewmodel
import test.cendana.wiliarko.ui.home.MainActivityViewmodel

class ViewModelFactory(private val listData: ListDataRepository):
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application): ViewModelFactory? {
            if(INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    if(INSTANCE == null) {
                        INSTANCE = ViewModelFactory(Injection.provideRepository(application))
                    }
                }
            }
            return INSTANCE
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SplashcreenViewmodel::class.java) -> SplashcreenViewmodel(listData) as (T)
            modelClass.isAssignableFrom(MainActivityViewmodel::class.java) -> MainActivityViewmodel(listData) as (T)
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }

    }
}