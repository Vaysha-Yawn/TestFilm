package test.film.data.api.di

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import test.film.data.api.GetFilmsRetrofit

val retrofitModule = module {
    single {
        val client = OkHttpClient.Builder().build()
        Retrofit.Builder()
            .baseUrl("https://s3-eu-west-1.amazonaws.com/sequeniatesttask/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(GetFilmsRetrofit::class.java)
    }
}