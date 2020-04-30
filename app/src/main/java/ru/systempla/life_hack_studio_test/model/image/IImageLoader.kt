package ru.systempla.life_hack_studio_test.model.image

interface IImageLoader<T> {
    fun loadInto(url: String?, container: T)
}