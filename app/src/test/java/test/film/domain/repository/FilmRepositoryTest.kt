package test.film.domain.repository

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import test.film.data.api.GetFilmsRetrofit
import test.film.domain.model.FilmData
import test.film.domain.model.FilmResponse

class FilmRepositoryTest {
    private val getFilmsRetrofitMockk: GetFilmsRetrofit = mockk()
    private val filmsRepository = FilmsRepository(getFilmsRetrofitMockk)

    @Test
    fun `getFilms should return list of films`() = runBlocking {
        //preparation
        val expectedFilms = listOf(
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
        val filmResponse = FilmResponse(expectedFilms)

        coEvery { getFilmsRetrofitMockk.getFilms() } returns filmResponse

        // test
        val result = filmsRepository.getFilms()

        // check
        assertEquals(expectedFilms, result)
    }

    @Test
    fun `getFilms should return empty list when api returns empty list`() = runBlocking {
        // preparation
        val expectedFilms = emptyList<FilmData>()
        val filmResponse = FilmResponse(expectedFilms)

        coEvery { getFilmsRetrofitMockk.getFilms() } returns filmResponse

        // test
        val result = filmsRepository.getFilms()

        // check
        assertEquals(expectedFilms, result)
    }
}