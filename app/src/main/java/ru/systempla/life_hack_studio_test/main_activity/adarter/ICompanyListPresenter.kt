package ru.systempla.life_hack_studio_test.main_activity.adarter

import io.reactivex.subjects.PublishSubject
import ru.systempla.life_hack_studio_test.main_activity.CompanyItemView

interface ICompanyListPresenter {
    fun bind(view: CompanyItemView)
    fun getCount(): Int
    fun getClickSubject(): PublishSubject<CompanyItemView>
}
