package test.film.presentation.filmGalleryScreen.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import test.film.domain.model.FilmData
import test.film.presentation.utils.theme.TestFilmTheme
import test.film.presentation.utils.theme.Typography

@Composable
fun FilmCard(modifier: Modifier, film: FilmData, openDetails: (FilmData) -> Unit) {
    Column(modifier.clickable { openDetails(film) }) {
        Poster(film)
        Text(film.localizedName?:"",
            style = Typography.titleSmall, maxLines = 2,
            overflow = TextOverflow.Ellipsis, modifier = Modifier.padding( top = 8.dp))
        Spacer(Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun FilmCardPreview(){
    TestFilmTheme {
        FilmCard(Modifier, FilmData.exampleData){}
    }
}