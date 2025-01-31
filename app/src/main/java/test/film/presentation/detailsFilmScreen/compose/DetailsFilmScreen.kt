package test.film.presentation.detailsFilmScreen.compose

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import test.film.domain.model.FilmData
import test.film.presentation.filmGalleryScreen.compose.Wrapper
import test.film.presentation.utils.theme.Typography

@Composable
fun DetailsFilmScreen(back: () -> Unit, film: FilmData) {
    BackHandler(onBack = back)
    Wrapper(
        topBar = {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .width(24.dp)
                    .height(24.dp)
                    .clickable(onClick = back)
            )
            Text(
                film.name ?: "",
                style = Typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.onPrimary,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.width(40.dp))
        },
    ) {
        DetailsFilm(film)
    }
}