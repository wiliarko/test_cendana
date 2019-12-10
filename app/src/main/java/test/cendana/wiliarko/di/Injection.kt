package test.cendana.wiliarko.di

import android.app.Application
import test.cendana.wiliarko.data.source.ListDataRepository
import test.cendana.wiliarko.data.source.local.LocalRepository
import test.cendana.wiliarko.data.source.remote.RemoteRepository

class Injection {
    companion object {
        fun provideRepository(application: Application): ListDataRepository{
            val remoteRepository = RemoteRepository.getInstance()
            val localRepository = LocalRepository.getInstance(application)
            return ListDataRepository.getInstance(remoteRepository, localRepository)
        }
    }
}