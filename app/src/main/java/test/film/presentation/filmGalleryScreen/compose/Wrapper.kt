package test.film.presentation.filmGalleryScreen.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import test.film.presentation.utils.theme.TestFilmTheme

@Composable
fun Wrapper(topBar: @Composable () -> Unit, content: @Composable () -> Unit) {
    TestFilmTheme {
        Scaffold(
            topBar = topBar,
        ) { innerPadding ->
            Column(Modifier.padding(innerPadding)) {
                content()
            }
        }
    }
}