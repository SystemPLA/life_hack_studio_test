package ru.systempla.life_hack_studio_test.main_activity

import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.systempla.life_hack_studio_test.main_activity.adarter.ICompanyListPresenter
import ru.systempla.life_hack_studio_test.model.entity.Company
import ru.systempla.life_hack_studio_test.model.repo.ICompaniesRepo
import java.util.*
import javax.inject.Inject

@InjectViewState
class MainPresenter(private val mainThreadScheduler: Scheduler, private val ioThreadScheduler: Scheduler) :
    MvpPresenter<MainView>() {

    internal class CompaniesListPresenter : ICompanyListPresenter {

        override val count: Int
            get() = companyBlocks.size

        override var clickSubject: PublishSubject<CompanyItemView> =
            PublishSubject.create<CompanyItemView>()

        override var companyBlocks = ArrayList<Company>()

        override fun bind(view: CompanyItemView) {
            view.rvInfoTV.text = companyBlocks[view.pos].name
        }

    }

    val companiesListPresenter : ICompanyListPresenter = CompaniesListPresenter()

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
                companiesListPresenter.companyBlocks.addAll(model)
                viewState.updateList()
                viewState.hideLoading()

            }, { t ->
                viewState.showMessage("Ошбка загрузки данных")
                viewState.hideLoading()
            })
    }
}