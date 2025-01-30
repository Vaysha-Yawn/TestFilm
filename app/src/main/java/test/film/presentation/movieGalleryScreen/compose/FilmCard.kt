package test.film.presentation.movieGalleryScreen.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import test.film.domain.model.FilmData
import test.film.presentation.utils.theme.TestFilmTheme
import test.film.presentation.utils.theme.Typography

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FilmCard(modifier: Modifier, film: FilmData, openDetails: (FilmData) -> Unit) {
    Column(modifier.clickable { openDetails(film) }) {
        GlideImage(film.imageUrl, film.localizedName, modifier.fillMaxWidth(), loading = placeholder(
            ColorPainter(Color.Gray)
        ))
        Text(film.name?:"",
            style = Typography.titleSmall, maxLines = 2,
            overflow = TextOverflow.Ellipsis)
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