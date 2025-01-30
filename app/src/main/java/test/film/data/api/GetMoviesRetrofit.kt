package test.film.data.api

import retrofit2.http.GET
import test.film.domain.model.FilmResponse

interface GetMoviesRetrofit {
    @GET("films.json")
    suspend fun getMovies(): FilmResponse
}