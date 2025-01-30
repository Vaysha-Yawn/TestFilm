package test.film.presentation.movieGalleryScreen.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class MovieGalleryVM:ViewModel() {

    private val uiStateMutable = mutableStateOf(MovieGalleryUiState.Loading)
    val uiState : State<MovieGalleryUiState> = uiStateMutable

    private val activeGenreMutable = mutableStateOf("")
    val activeGenre : State<String> = activeGenreMutable

    init {
        loadData()
    }

    private fun loadData() {

    }

    fun clickToGenre(genre:String){

    }

    fun reload(){

    }
}