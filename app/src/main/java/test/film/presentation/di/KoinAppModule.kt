package test.film.presentation.di

import test.film.data.api.di.retrofitModule
import test.film.domain.repository.di.repositoryModule

val appModule = listOf(
    detailsFilmVMModule, filmGalleryVMModule, repositoryModule, retrofitModule
)