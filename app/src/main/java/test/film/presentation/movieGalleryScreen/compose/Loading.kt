package test.film.presentation.movieGalleryScreen.compose

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.isActive
import test.film.presentation.utils.theme.TestFilmTheme

@Composable
fun Loading(){
    val degreesState = remember { mutableFloatStateOf(0f) }
    val degrees = animateFloatAsState(degreesState.floatValue, label = "degrees")

    CircularProgressIndicator(
        progress = { 0.25f },
        modifier = Modifier.rotate(degrees.value),
        color = MaterialTheme.colorScheme.background,
        strokeWidth = 5.dp,
        trackColor = MaterialTheme.colorScheme.secondary,
    )

    LaunchedEffect(Unit) {
        /*while (isActive){
            degreesState.floatValue+=1f
            if (degreesState.floatValue > 360){
                degreesState.floatValue = 0f
            }
        }*/
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingPreview(){
    TestFilmTheme {
        Loading()
    }
}