package ru.systempla.life_hack_studio_test.main_activity.adarter

import io.reactivex.subjects.PublishSubject
import ru.systempla.life_hack_studio_test.main_activity.CompanyItemView
import ru.systempla.life_hack_studio_test.model.entity.Company

interface ICompanyListPresenter {
    val count: Int
    var companyBlocks: ArrayList<Company>
    var clickSubject: PublishSubject<CompanyItemView>
    fun bind(view: CompanyItemView)
}
