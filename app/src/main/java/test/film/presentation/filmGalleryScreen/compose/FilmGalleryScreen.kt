package test.film.presentation.filmGalleryScreen.compose

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import test.film.R
import test.film.domain.model.FilmData
import test.film.presentation.filmGalleryScreen.viewmodel.FilmGalleryUiState
import test.film.presentation.utils.theme.Typography

@Composable
fun FilmGalleryScreen(
    uiState: MutableState<FilmGalleryUiState>,
    openDetails: (FilmData) -> Unit,
    clickToGenre: (String) -> Unit,
    activeGenre: String,
    reload: () -> Unit
) {
    Wrapper(
        {
            Text(
                stringResource(R.string.films),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f),
                style = Typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    ) {
        when (val ui = uiState.value) {
            FilmGalleryUiState.Loading -> Loading()
            is FilmGalleryUiState.Error -> ShowError(ui.message, reload)
            is FilmGalleryUiState.Success -> FilmGalleryScreenSuccess(
                ui.films,
                ui.genres,
                openDetails,
                clickToGenre,
                activeGenre
            )
        }
    }
}