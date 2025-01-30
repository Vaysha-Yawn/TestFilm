package test.film.domain.usecase

import test.film.domain.model.FilmData
import test.film.domain.repository.MoviesRepository

class GetGenresUseCase() {
    suspend operator fun invoke(movies:List<FilmData>): List<String> {
        return movies.flatMap { it.genres }
    }
}