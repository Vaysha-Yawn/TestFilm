package test.film.domain.usecase

import test.film.domain.model.FilmData
import test.film.domain.repository.FilmsRepository

class GetSortedFilmsUseCase(
    private val repository: FilmsRepository
) {
    suspend operator fun invoke(): List<FilmData> {
         return repository.getFilms().sortedBy { it.localizedName }
    }
}