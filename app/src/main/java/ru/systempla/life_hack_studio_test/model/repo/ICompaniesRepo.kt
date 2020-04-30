package ru.systempla.life_hack_studio_test.model.repo

import io.reactivex.Single
import ru.systempla.life_hack_studio_test.model.entity.Company
import ru.systempla.life_hack_studio_test.model.entity.CompanyDetails

interface ICompaniesRepo {
    fun getCompanies(): Single<List<Company?>?>?
    fun getCompanyDetails(id: Int): Single<CompanyDetails?>?
}