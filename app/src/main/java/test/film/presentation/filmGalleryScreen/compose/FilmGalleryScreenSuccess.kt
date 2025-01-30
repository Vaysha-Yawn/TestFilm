package test.film.presentation.filmGalleryScreen.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import test.film.domain.model.FilmData

@Composable
fun FilmGalleryScreenSuccess(
    films: List<FilmData>,
    genres: List<String>,
    openDetails: (FilmData) -> Unit,
    clickToGenre: (String) -> Unit,
    activeGenre:String
) {
    LazyColumn {
        item {
            FilterGenre(genres, activeGenre, clickToGenre)
            Spacer(Modifier.height(16.dp))
            FilmGallery(films, openDetails)
        }
    }
}