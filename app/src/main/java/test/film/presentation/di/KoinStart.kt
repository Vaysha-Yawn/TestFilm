package test.film.presentation.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

fun koinStart(context: Context) {
    startKoin {
        androidLogger()
        androidContext(context)
        modules(appModule)
    }
}