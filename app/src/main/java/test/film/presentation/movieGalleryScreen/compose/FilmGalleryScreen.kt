package test.film.presentation.movieGalleryScreen.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import test.film.R
import test.film.domain.model.FilmData
import test.film.presentation.movieGalleryScreen.viewmodel.FilmGalleryUiState
import test.film.presentation.utils.theme.Typography

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun FilmGalleryScreen(
    uiState: MutableState<FilmGalleryUiState>,
    openDetails: (FilmData) -> Unit,
    clickToGenre: (String) -> Unit,
    activeGenre: String,
    reload: () -> Unit
) {
    Wrapper(
        {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.films),
                        modifier = Modifier.fillMaxSize(),
                        textAlign = TextAlign.Center,
                        style = Typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
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