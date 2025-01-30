package test.film.data.api.di

import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import test.film.data.api.GetMoviesRetrofit

val retrofitModule = module {
    single {
        val gson = GsonBuilder().setLenient().create()

        Retrofit.Builder()
            .baseUrl("https://s3-eu-west-1.amazonaws.com/sequeniatesttask/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(GetMoviesRetrofit::class.java)
    }
}