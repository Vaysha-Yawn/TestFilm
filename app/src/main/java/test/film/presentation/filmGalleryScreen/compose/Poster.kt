package test.film.presentation.filmGalleryScreen.compose

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import test.film.R
import test.film.domain.model.FilmData

@Composable
@OptIn(ExperimentalGlideComposeApi::class)
fun Poster(film: FilmData) {
    GlideImage(
        film.imageUrl,
        film.localizedName,
        Modifier
            .height(222.dp)
            .width(160.dp)
            .clip(RoundedCornerShape(4.dp)),
        contentScale = ContentScale.Crop,
        alignment = Alignment.CenterStart,
        loading = placeholder(
            R.drawable.img
        ),
        failure = placeholder(
            R.drawable.img
        ),
    )
}