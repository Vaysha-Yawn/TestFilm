package test.film.presentation.movieGalleryScreen.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import test.film.R
import test.film.presentation.utils.theme.ColorTransparent
import test.film.presentation.utils.theme.TestFilmTheme
import test.film.presentation.utils.theme.Typography

@Composable
fun FilterGenre(genres: List<String>, activeGenre: String, clickToGenre: (String) -> Unit) {
    Column {
        Text(
            stringResource(R.string.genres),
            style = Typography.titleMedium,
            modifier = Modifier.padding(16.dp)
        )
        genres.forEach {
            Text(
                it,
                style = Typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        if (activeGenre == it) {
                            MaterialTheme.colorScheme.secondary
                        } else ColorTransparent
                    )
                    .clickable (onClick = { clickToGenre(it) })
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterGenrePreview() {
    TestFilmTheme {
        val allGenres = listOf("Научная фантастика", "Комедия", "Драма")
        val activeGenre = allGenres[0]
        FilterGenre(allGenres, activeGenre) {}
    }
}