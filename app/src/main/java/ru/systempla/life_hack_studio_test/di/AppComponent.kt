package ru.systempla.life_hack_studio_test.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = {AppModule.class})
interface AppComponent {

}