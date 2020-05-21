package ru.systempla.life_hack_studio_test.main_activity

import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.systempla.life_hack_studio_test.main_activity.adarter.ICompanyListPresenter
import ru.systempla.life_hack_studio_test.model.repo.ICompaniesRepo
import java.util.*
import javax.inject.Inject

@InjectViewState
class MainPresenter(private val mainThreadScheduler: Scheduler, private val ioThreadScheduler: Scheduler) :
    MvpPresenter<MainView>() {

    internal class CompaniesListPresenter : ICompanyListPresenter {
        override fun getCount(): Int {
            TODO("Not yet implemented")
        }

        var clickSubject: PublishSubject<CompanyItemView> =
            PublishSubject.create<CompanyItemView>()
        var companyBlocks: List<ForecastEntityRestModel> =
            ArrayList<ForecastEntityRestModel>()

        fun bind(view: CompanyItemView) {
            view.
            setDateTime(companyBlocks[view.getPos()].dt)
            view.setTemperature(companyBlocks[view.getPos()].main.temp)
            view.setWeatherDescription(companyBlocks[view.getPos()].weather.get(0).description)
            view.setWeatherIcon(
                companyBlocks[view.getPos()].weather.get(0).id,
                companyBlocks[view.getPos()].weather.get(0).icon
            )
        }

        val count: Int
            get() = companyBlocks.size

        fun getClickSubject(): PublishSubject<CompanyItemView> {
            return clickSubject
        }
    }

    @Inject
    lateinit var companiesRepo: ICompaniesRepo

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun loadData() {
        viewState.showLoading()
        var disposable: Disposable? = companiesRepo.getCompanies()
            ?.subscribeOn(ioThreadScheduler)
            ?.observeOn(mainThreadScheduler)
            ?.subscribe({ model ->
                companiesListPresenter.companyBlocks.clear()
                companiesListPresenter.companyBlocks.addAll(model.list)
                viewState.updateList()
                viewState.hideLoading()

            }, { t ->
                viewState.showMessage("Ошбка загрузки данных")
                viewState.hideLoading()
            })
    }
}