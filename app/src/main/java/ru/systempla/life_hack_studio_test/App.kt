package ru.systempla.life_hack_studio_test

import android.app.Application
import timber.log.Timber
import ru.systempla.life_hack_studio_test.di.AppComponent
import ru.systempla.life_hack_studio_test.di.AppModule

class App : Application() {

    private var appComponent : AppComponent = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .build()
    private var instance : App = this

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    fun getAppComponent():AppComponent = appComponent
    fun getInstance():App = instance

}
