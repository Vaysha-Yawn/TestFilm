package test.film.presentation.movieGalleryScreen.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import test.film.R
import test.film.domain.model.FilmData
import test.film.presentation.utils.theme.TestFilmTheme
import test.film.presentation.utils.theme.Typography

@Composable
fun FilmGallery(films: List<FilmData>, openDetails: (FilmData) -> Unit) {
    val stateGrid = rememberLazyGridState()
    Column(Modifier.padding(16.dp)) {
        Text(
            stringResource(R.string.films),
            style = Typography.titleMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyVerticalGrid(GridCells.Fixed(2), state = stateGrid) {
            items(films){film->
                FilmCard(film, openDetails)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilmGalleryPreview() {
    TestFilmTheme {
        FilmGallery(listOf()) {}
    }
}