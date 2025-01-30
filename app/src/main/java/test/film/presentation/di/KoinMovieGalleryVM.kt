package test.film.presentation.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import test.film.domain.usecase.FilterFilmsByGenreUseCase
import test.film.domain.usecase.GetGenresUseCase
import test.film.domain.usecase.GetSortedFilmsUseCase
import test.film.presentation.movieGalleryScreen.viewmodel.FilmGalleryVM

val filmGalleryVMModule = module {
    viewModel {
        FilmGalleryVM(
            FilterFilmsByGenreUseCase(),
            GetSortedFilmsUseCase(get()),
            GetGenresUseCase()
        )
    }
}