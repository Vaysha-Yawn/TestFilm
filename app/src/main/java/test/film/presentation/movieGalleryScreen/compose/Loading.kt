package test.film.presentation.movieGalleryScreen.compose

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import test.film.presentation.utils.theme.TestFilmTheme

@Composable
fun Loading() {
    val degreesState = remember { mutableFloatStateOf(0f) }
    val degrees = animateFloatAsState(degreesState.floatValue, label = "degrees")
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            progress = { 0.25f },
            modifier = Modifier.rotate(degrees.value),
            color =
            MaterialTheme.colorScheme.background,
            strokeWidth = 5.dp,
            trackColor = MaterialTheme.colorScheme.secondary,
        )
    }
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            while (isActive) {
                degreesState.floatValue += 20f
                delay(50L)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingPreview() {
    TestFilmTheme {
        Loading()
    }
}