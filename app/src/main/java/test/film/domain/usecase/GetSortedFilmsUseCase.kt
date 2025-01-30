package test.film.domain.usecase

import test.film.domain.model.FilmData
import test.film.domain.repository.MoviesRepository

class GetSortedFilmsUseCase(
    private val repository: MoviesRepository
) {
    suspend operator fun invoke(): List<FilmData> {
        return repository.getMovies().sortedBy { it.localizedName }
    }
}