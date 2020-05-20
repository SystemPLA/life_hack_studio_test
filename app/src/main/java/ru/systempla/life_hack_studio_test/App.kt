package ru.systempla.life_hack_studio_test

import android.app.Application
import timber.log.Timber
import ru.systempla.life_hack_studio_test.di.AppComponent
import ru.systempla.life_hack_studio_test.di.AppModule
import ru.systempla.life_hack_studio_test.di.DaggerAppComponent

class App : Application() {
    companion object{
        lateinit var instance: App private set
    }

    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        instance = this
        setup()
    }

    fun getApplicationComponent(): AppComponent {
        return appComponent
    }

    fun setup() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}
