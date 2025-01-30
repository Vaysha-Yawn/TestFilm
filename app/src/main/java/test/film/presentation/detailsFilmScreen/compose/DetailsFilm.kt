package test.film.presentation.detailsFilmScreen.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import test.film.R
import test.film.domain.model.FilmData
import test.film.presentation.filmGalleryScreen.compose.Poster
import test.film.presentation.utils.theme.TestFilmTheme
import test.film.presentation.utils.theme.Typography
import test.film.presentation.utils.theme.ratingNumberStyle
import test.film.presentation.utils.theme.ratingTextStyle
import test.film.presentation.utils.theme.subtextStyle

@Composable
fun DetailsFilm(film: FilmData) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        item {
            Box(Modifier.fillMaxWidth().padding(vertical = 24.dp), contentAlignment = Alignment.Center){
                Poster(film)
            }
        }
        item {
            Text(film.localizedName ?: "", style = Typography.titleLarge)
            Spacer(Modifier.height(10.dp))
        }
        item {
            Text(
                film.genres.filterNotNull()
                    .genresToString() + film.year + " " + stringResource(R.string.year),
                style = subtextStyle,
                color = MaterialTheme.colorScheme.outline
            )
            Spacer(Modifier.height(10.dp))
        }
        item {
            if (film.rating == null) return@item
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    film.rating.ratingToDouble().toString(),
                    style = ratingNumberStyle,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    stringResource(R.string.rating_source),
                    style = ratingTextStyle,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(Modifier.height(14.dp))
        }
        item {
            Text(film.description ?: "", style = Typography.bodySmall)
            Spacer(Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilmDetailsPreview() {
    TestFilmTheme {
        DetailsFilm(FilmData.exampleData)
    }
}