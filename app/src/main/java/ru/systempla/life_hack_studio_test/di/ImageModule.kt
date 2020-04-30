package ru.systempla.life_hack_studio_test.di

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import ru.systempla.life_hack_studio_test.model.image.GlideImageLoader
import ru.systempla.life_hack_studio_test.model.image.IImageLoader


@Module(includes = [ApiModule::class])
class ImageModule {

    @Provides
    fun imageLoader(): IImageLoader<ImageView> = GlideImageLoader()
}