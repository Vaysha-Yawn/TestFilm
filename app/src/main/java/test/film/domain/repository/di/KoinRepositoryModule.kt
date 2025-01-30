package test.film.domain.repository.di

import org.koin.dsl.module
import test.film.domain.repository.MoviesRepository

val repositoryModule = module {
    single {
        MoviesRepository(get())
    }
}