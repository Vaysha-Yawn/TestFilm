package test.film.presentation.movieGalleryScreen.viewmodel

import test.film.domain.model.FilmData

sealed interface MovieGalleryUiState{
    data object Loading: MovieGalleryUiState
    data class Success(val films: List<FilmData>, val genres:List<String>): MovieGalleryUiState
    data class Error(val message: String): MovieGalleryUiState
}