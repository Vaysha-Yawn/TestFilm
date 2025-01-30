package test.film.domain.repository

import test.film.data.api.GetMoviesRetrofit
import test.film.domain.model.FilmData

class MoviesRepository(private val api: GetMoviesRetrofit) {
    suspend fun getMovies(): List<FilmData> {
        return api.getMovies().films
    }
}