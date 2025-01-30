package test.film.presentation.movieGalleryScreen.viewmodel

import test.film.domain.model.FilmData

sealed interface FilmGalleryUiState{
    data object Loading: FilmGalleryUiState
    data class Success(val films: List<FilmData>, val genres:List<String>): FilmGalleryUiState
    data class Error(val message: String): FilmGalleryUiState
}