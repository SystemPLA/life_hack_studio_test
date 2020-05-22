package ru.systempla.life_hack_studio_test.model.repo

import io.reactivex.Single
import ru.systempla.life_hack_studio_test.model.api.IDataSource
import ru.systempla.life_hack_studio_test.model.entity.Company
import ru.systempla.life_hack_studio_test.model.entity.CompanyDetails

class CompaniesRepo(var api: IDataSource) : ICompaniesRepo {

    override fun getCompanies(): Single<Collection<Company>>? = api.getCompanies()

    override fun getCompanyDetails(id: Int): Single<CompanyDetails>? = api.getCompanyDetails(id)
}