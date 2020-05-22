package ru.systempla.life_hack_studio_test.di

import dagger.Module
import dagger.Provides
import ru.systempla.life_hack_studio_test.model.api.IDataSource
import ru.systempla.life_hack_studio_test.model.repo.CompaniesRepo
import ru.systempla.life_hack_studio_test.model.repo.ICompaniesRepo
import javax.inject.Singleton

@Module
class RepoModule {
    @Singleton
    @Provides
    fun companiesRepo(api: IDataSource): ICompaniesRepo? {
        return CompaniesRepo(api)
    }
}