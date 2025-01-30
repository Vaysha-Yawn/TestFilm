package test.film.presentation.detailsFilmScreen.compose

import androidx.activity.compose.BackHandler
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import test.film.R
import test.film.domain.model.FilmData
import test.film.presentation.movieGalleryScreen.compose.Wrapper
import test.film.presentation.utils.theme.Typography

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun DetailsFilmScreen(back: () -> Unit, film: FilmData) {
    BackHandler (onBack = back)
    Wrapper(
        topBar = {
        TopAppBar(
            title = { Text(film.name, style = Typography.bodyLarge) },
            navigationIcon = {
                IconButton(onClick = back) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            })
    }
    ) {
        DetailsFilm(film)
    }
}