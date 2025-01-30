package test.film.presentation.detailsFilmScreen.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import test.film.domain.model.FilmData

class DetailsFilmVM:ViewModel() {
    private val filmDataState = mutableStateOf(FilmData.exampleData)
    val filmData : State<FilmData> = filmDataState

    fun setData(film: FilmData){
        filmDataState.value = film
    }
}