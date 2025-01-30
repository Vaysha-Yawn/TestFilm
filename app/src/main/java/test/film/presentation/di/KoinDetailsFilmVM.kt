package test.film.presentation.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import test.film.presentation.detailsFilmScreen.viewmodel.DetailsFilmVM

val detailsFilmVMModule = module{
    viewModel {
        DetailsFilmVM()
    }
}