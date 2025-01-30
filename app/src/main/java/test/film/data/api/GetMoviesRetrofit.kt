package test.film.data.api

import retrofit2.http.GET
import test.film.domain.model.FilmResponse

interface GetMoviesRetrofit {
    @GET("https://s3-eu-west-1.amazonaws.com/sequeniatesttask/films.json")
    suspend fun getMovies(): FilmResponse
}