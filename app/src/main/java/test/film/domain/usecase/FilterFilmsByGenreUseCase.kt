package test.film.domain.usecase

import test.film.domain.model.FilmData
import test.film.domain.repository.MoviesRepository

class FilterFilmsByGenreUseCase() {
    operator fun invoke(films:List<FilmData>, activeGenre:String): List<FilmData> {
        return films.filter { it.genres.contains(activeGenre) }
    }
}