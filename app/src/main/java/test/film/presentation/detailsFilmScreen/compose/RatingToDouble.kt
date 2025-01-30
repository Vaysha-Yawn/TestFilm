package test.film.presentation.detailsFilmScreen.compose

fun Double.ratingToDouble():Double{
    return (this*10).toInt().toDouble()/10
}