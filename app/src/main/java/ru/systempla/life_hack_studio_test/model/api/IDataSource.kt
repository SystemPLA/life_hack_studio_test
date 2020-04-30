package ru.systempla.life_hack_studio_test.model.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.systempla.life_hack_studio_test.model.entity.Company
import ru.systempla.life_hack_studio_test.model.entity.CompanyDetails


interface IDataSource {

    @GET
    fun getCompanies(): Single<List<Company?>?>?

    @GET
    fun getCompanyDetails(@Query("id") id: Int): Single<CompanyDetails?>?
}