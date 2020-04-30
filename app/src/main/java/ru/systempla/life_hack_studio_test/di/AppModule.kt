package ru.systempla.life_hack_studio_test.di

import dagger.Module
import dagger.Provides
import ru.systempla.life_hack_studio_test.App

@Module
class AppModule(app: App) {
    private val app: App = app
    @Provides
    fun app(): App {
        return app
    }
}