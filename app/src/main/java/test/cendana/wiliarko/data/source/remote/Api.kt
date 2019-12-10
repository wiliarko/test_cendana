package test.cendana.wiliarko.data.source.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import test.cendana.wiliarko.BuildConfig.BASE_URL

class Api {
    companion object {
        fun getClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}