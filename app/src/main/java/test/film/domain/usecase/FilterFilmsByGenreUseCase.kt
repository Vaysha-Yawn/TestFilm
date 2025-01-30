package test.film.domain.usecase

import test.film.domain.model.FilmData

class FilterFilmsByGenreUseCase() {
    operator fun invoke(films:List<FilmData>, activeGenre:String): List<FilmData> {
        return films.filter { it.genres.contains(activeGenre) }
    }
}