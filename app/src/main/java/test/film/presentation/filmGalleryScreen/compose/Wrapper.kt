package test.film.presentation.filmGalleryScreen.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import test.film.presentation.utils.theme.TestFilmTheme

@Composable
fun Wrapper(topBar: @Composable RowScope.() -> Unit, content: @Composable () -> Unit) {
    TestFilmTheme {
        Column(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
            Row(
                Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .fillMaxWidth()
                    .height(56.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                topBar()
            }
            content()
        }
    }
}