package test.film.presentation.movieGalleryScreen.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
fun FilmCard(modifier: Modifier, film: FilmData, openDetails: (FilmData) -> Unit) {
    Column(modifier.clickable { openDetails(film) }) {
        AsyncImage(film.imageUrl, film.name, modifier.fillMaxWidth())
        Text(film.localizedName?:"",
            style = Typography.titleSmall, maxLines = 2,
            overflow = TextOverflow.Ellipsis)
    }
}

@Preview(showBackground = true)
@Composable
fun FilmCardPreview(){
    TestFilmTheme {
        FilmCard(Modifier, FilmData.exampleData){}
    }
}