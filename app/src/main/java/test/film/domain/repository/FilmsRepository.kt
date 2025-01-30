package test.film.domain.repository

import test.film.data.api.GetFilmsRetrofit
import test.film.domain.model.FilmData

class FilmsRepository(private val api: GetFilmsRetrofit) {
    suspend fun getFilms(): List<FilmData> {
        return api.getFilms().films
    }
}