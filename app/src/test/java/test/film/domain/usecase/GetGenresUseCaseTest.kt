package test.film.domain.usecase

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import test.film.domain.model.FilmData

class GetGenresUseCaseTest {
    private val getGenresUseCase = GetGenresUseCase()

    @Test
    fun `getGenresUseCase should return all unique genres from a list of movies`() = runBlocking {
        //preparation
        val films = listOf(
            FilmData(
                id = 0,
                localizedName = "Имя",
                name = "Name",
                year = 2025,
                rating = 9.1,
                imageUrl = null,
                description = "Описание фильма",
                genres = listOf("драма", "комедия")
            ),
            FilmData(
                id = 1,
                localizedName = "Имя 2",
                name = "Name 2",
                year = 2025,
                rating = 9.2,
                imageUrl = "",
                description = "Описание фильма 2",
                genres = listOf("мюзикл")
            )
        )
        val expectedResult = listOf("драма", "комедия", "мюзикл")

        // test
        val result = getGenresUseCase(films)

        // check
        assertEquals(expectedResult, result)
    }
}