package ru.systempla.life_hack_studio_test.di

import dagger.Component
import ru.systempla.life_hack_studio_test.details_activity.DetailsActivity
import ru.systempla.life_hack_studio_test.details_activity.DetailsPresenter
import ru.systempla.life_hack_studio_test.main_activity.MainActivity
import ru.systempla.life_hack_studio_test.main_activity.MainPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ImageModule::class
])
interface AppComponent {
    fun inject(mainPresenter: MainPresenter)
    fun inject(detailsPresenter: DetailsPresenter)
    fun inject(mainActivity: MainActivity)
    fun inject(detailsActivity: DetailsActivity)
}