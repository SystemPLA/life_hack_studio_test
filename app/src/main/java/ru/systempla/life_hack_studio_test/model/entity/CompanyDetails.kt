package ru.systempla.life_hack_studio_test.model.entity

import com.google.gson.annotations.Expose

class CompanyDetails(
    @Expose var id: String?,
    @Expose var name: String?,
    @Expose var img: String?,
    @Expose var description: String?,
    @Expose var lat: Double?,
    @Expose var lon: Double?,
    @Expose var www: String?,
    @Expose var phone: String?)
