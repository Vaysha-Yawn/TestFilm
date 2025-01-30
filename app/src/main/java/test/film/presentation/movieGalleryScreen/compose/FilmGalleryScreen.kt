package test.film.presentation.movieGalleryScreen.compose

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import test.film.R
import test.film.presentation.utils.theme.Typography

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun FilmGalleryScreen() {
    Wrapper(
        { TopAppBar(title = { Text(stringResource(R.string.title_top_bar_main), style = Typography.bodyLarge) }) }
    ) {
        FilterGenre()
        FilmGallery()
    }
}