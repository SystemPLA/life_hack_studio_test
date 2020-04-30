package ru.systempla.life_hack_studio_test.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.systempla.life_hack_studio_test.model.api.IDataSource
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Named("baseUrl")
    @Provides
    fun baseUrl(): String = "http://megakohz.bget.ru/test_task/test.php"

    @Singleton
    @Provides
    fun apiService( @Named("baseUrl") baseUrl: String): IDataSource
            = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IDataSource::class.java)
}