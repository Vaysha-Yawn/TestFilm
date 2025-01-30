package test.film.presentation.detailsFilmScreen.compose

fun List<String>.genresToString():String{
    var result = ""
    this.forEach {
        result+= "$it, "
    }
    return result
}