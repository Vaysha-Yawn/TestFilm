package test.film.presentation

import android.app.Application
import test.film.presentation.di.koinStart


class App:Application() {

    override fun onCreate() {
        super.onCreate()
        koinStart(this)
    }
}