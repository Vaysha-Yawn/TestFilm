package test.film.presentation.movieGalleryScreen.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import test.film.domain.model.FilmData
import test.film.presentation.utils.theme.TestFilmTheme
import test.film.presentation.utils.theme.Typography

@Composable
fun FilmCard(film: FilmData, openDetails: (FilmData) -> Unit) {
    Column(Modifier.clickable { openDetails(film) }) {
        AsyncImage(film.imageUrl, film.name)
        Text(film.localizedName,
            style = Typography.titleSmall, maxLines = 2,
            overflow = TextOverflow.Ellipsis)
    }
}

@Preview(showBackground = true)
@Composable
fun FilmCardPreview(){
    TestFilmTheme {
        FilmCard(FilmData.exampleData){}
    }
}