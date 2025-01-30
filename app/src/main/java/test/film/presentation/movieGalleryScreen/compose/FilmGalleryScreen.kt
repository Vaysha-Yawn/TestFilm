package test.film.presentation.movieGalleryScreen.compose

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import test.film.R
import test.film.domain.model.FilmData
import test.film.presentation.movieGalleryScreen.viewmodel.FilmGalleryUiState
import test.film.presentation.utils.theme.Typography

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun FilmGalleryScreen(uiState: FilmGalleryUiState, openDetails: (FilmData) -> Unit, clickToGenre: (String) -> Unit, activeGenre:String, reload:()->Unit) {
    Wrapper(
        { TopAppBar(title = { Text(stringResource(R.string.title_top_bar_main), style = Typography.bodyLarge) }) }
    ) {
        when(uiState){
            FilmGalleryUiState.Loading -> Loading()
            is FilmGalleryUiState.Error -> ShowError(uiState.message, reload)
            is FilmGalleryUiState.Success -> FilmGalleryScreenSuccess(uiState.films, uiState.genres, openDetails, clickToGenre, activeGenre)
        }
    }
}