package test.film.presentation.utils.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable


val ColorScheme = darkColorScheme(
    primary = ColorBlue,
    secondary = ColorYellow,
    background = ColorWhite,
    onPrimary = ColorWhite,
    onSecondary = ColorBlack,
    onBackground = ColorBlack,
    surface = ColorWhite,
    onSurface = ColorBlack,
    outline = ColorGrey,
)

@Composable
fun TestFilmTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = ColorScheme,
        typography = Typography,
        content = content
    )
}