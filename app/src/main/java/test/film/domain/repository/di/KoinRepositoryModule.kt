package test.film.domain.repository.di

import org.koin.dsl.module
import test.film.domain.repository.FilmsRepository

val repositoryModule = module {
    single {
        FilmsRepository(get())
    }
}