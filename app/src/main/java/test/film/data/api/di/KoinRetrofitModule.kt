package test.film.data.api.di

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import test.film.data.api.GetMoviesRetrofit

val retrofitModule = module {
    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GetMoviesRetrofit::class.java)
    }
}