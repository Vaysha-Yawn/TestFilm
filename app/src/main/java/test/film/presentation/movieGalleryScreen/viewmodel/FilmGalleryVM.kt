package test.film.presentation.movieGalleryScreen.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import test.film.domain.model.FilmData
import test.film.domain.usecase.FilterFilmsByGenreUseCase
import test.film.domain.usecase.GetGenresUseCase
import test.film.domain.usecase.GetSortedFilmsUseCase


class FilmGalleryVM(
    private val filterFilmsByGenreUseCase: FilterFilmsByGenreUseCase,
    private val getSortedFilmsUseCase: GetSortedFilmsUseCase,
    private val getGenreUseCase: GetGenresUseCase
) : ViewModel() {
    private val allFilms = mutableStateOf<List<FilmData>>(listOf())
    private val uiStateMutable = mutableStateOf<FilmGalleryUiState>(FilmGalleryUiState.Loading)
    val uiState: State<FilmGalleryUiState> = uiStateMutable

    private val activeGenreMutable = mutableStateOf("")
    val activeGenre: State<String> = activeGenreMutable

    init {
        loadData()
    }

    private fun loadData() {
        uiStateMutable.value = FilmGalleryUiState.Loading
        val filmsPromise = viewModelScope.async { getSortedFilmsUseCase.invoke() }
        val coroutineExceptionHandler = CoroutineExceptionHandler() { context, throwable ->
            onError(throwable.message ?: "")
        }
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                val films = filmsPromise.await()
                val genres = getGenreUseCase.invoke(films)
                allFilms.value = films
                uiStateMutable.value = FilmGalleryUiState.Success(films, genres)
            } catch (e: Exception) {
                onError(e.message ?: "")
            }
        }
    }

    private fun onError(error: String) {
        uiStateMutable.value = FilmGalleryUiState.Error(error)
    }

    fun clickToGenre(genre: String) {
        val currentState = uiState.value as FilmGalleryUiState.Success
        if (activeGenre.value == genre) {
            activeGenreMutable.value = ""
            uiStateMutable.value = FilmGalleryUiState.Success(allFilms.value, currentState.genres)
        } else {
            activeGenreMutable.value = genre
            val filteredFilms = filterFilmsByGenreUseCase.invoke(allFilms.value, genre)
            uiStateMutable.value = FilmGalleryUiState.Success(filteredFilms, currentState.genres)
        }
    }

    fun reload() {
        loadData()
    }
}