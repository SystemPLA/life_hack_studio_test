package ru.systempla.life_hack_studio_test.model.entity

import com.google.gson.annotations.Expose

class CompanyDetails {
    @Expose
    var id: String? = null
    @Expose
    var name: String? = null
    @Expose
    var img: String? = null
    @Expose
    var description: String? = null
    @Expose
    var lat: Double? = null
    @Expose
    var lon: Double? = null
    @Expose
    var www: String? = null
    @Expose
    var phone: String? = null
}