package test.film.presentation.movieGalleryScreen.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import test.film.domain.model.FilmData
import test.film.domain.usecase.FilterFilmsByGenreUseCase
import test.film.domain.usecase.GetGenresUseCase
import test.film.domain.usecase.GetSortedFilmsUseCase


class FilmGalleryVM(
    private val filterFilmsByGenreUseCase: FilterFilmsByGenreUseCase,
    private val getSortedFilmsUseCase: GetSortedFilmsUseCase,
    private val getGenreUseCase: GetGenresUseCase
) : ViewModel() {
    private var allFilms: List<FilmData> = listOf()
    val uiState = mutableStateOf<FilmGalleryUiState>(FilmGalleryUiState.Loading)
    val activeGenre = mutableStateOf("")

    init {
        loadData()
    }

    private fun loadData() {
        uiState.value = FilmGalleryUiState.Loading
        val coroutineExceptionHandler = CoroutineExceptionHandler() { context, throwable ->
            onError(throwable.message ?: "")
        }
        viewModelScope.launch(coroutineExceptionHandler) {
            withContext(Dispatchers.IO){
                val films = getSortedFilmsUseCase()
                val genres = getGenreUseCase(films)
                allFilms = films
                uiState.value = FilmGalleryUiState.Success(films, genres)
            }
        }
    }

    private fun onError(error: String) {
        uiState.value = FilmGalleryUiState.Error(error)
    }

    fun clickToGenre(genre: String) {
        if (uiState.value !is FilmGalleryUiState.Success) return
        val currentState = uiState.value as FilmGalleryUiState.Success
        if (activeGenre.value == genre) {
            activeGenre.value = ""
            uiState.value = FilmGalleryUiState.Success(allFilms, currentState.genres)
        } else {
            activeGenre.value = genre
            val filteredFilms = filterFilmsByGenreUseCase.invoke(allFilms, genre)
            uiState.value = FilmGalleryUiState.Success(filteredFilms, currentState.genres)
        }
    }

    fun reload() {
        loadData()
    }
}