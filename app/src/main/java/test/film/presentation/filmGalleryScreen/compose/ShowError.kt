package test.film.presentation.filmGalleryScreen.compose

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import test.film.R

@Composable
fun ShowError(message: String, reload: () -> Unit) {
    val context = LocalContext.current
    val snackBarState = remember { SnackbarHostState() }
    Scaffold(snackbarHost = {
        SnackbarHost(snackBarState){data ->
            Snackbar(
                snackbarData = data,
                containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                actionColor = MaterialTheme.colorScheme.secondary,
            )
        }
    }
    ) { it }
    LaunchedEffect(Unit) {
        val snackbarResult = snackBarState.showSnackbar(
            context.getString(R.string.error),
            actionLabel = context.getString(R.string.try_again),
            duration = SnackbarDuration.Indefinite
        )
        when (snackbarResult) {
            SnackbarResult.Dismissed -> {}
            SnackbarResult.ActionPerformed -> reload()
        }
    }
}