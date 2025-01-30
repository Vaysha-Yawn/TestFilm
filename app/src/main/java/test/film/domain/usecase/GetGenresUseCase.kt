package test.film.domain.usecase

import test.film.domain.model.FilmData

class GetGenresUseCase() {
    suspend operator fun invoke(films:List<FilmData>): List<String> {
        return films.flatMap { it.genres }.filterNotNull().toSet().toList()
    }
}