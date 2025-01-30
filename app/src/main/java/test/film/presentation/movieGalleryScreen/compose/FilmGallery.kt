package test.film.presentation.movieGalleryScreen.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
    Column(Modifier.padding(16.dp)) {
        Text(
            stringResource(R.string.films),
            style = Typography.titleMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        for ((index, film) in films.withIndex()) {
            Row {
                if (index % 2 == 0) {
                    FilmCard(Modifier.weight(1f), film, openDetails)
                    Spacer(Modifier.width(8.dp))
                    if (films.size > index + 1) {
                        FilmCard(Modifier.weight(1f), films[index + 1], openDetails)
                    }
                }
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