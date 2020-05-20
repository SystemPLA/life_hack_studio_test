package ru.systempla.life_hack_studio_test.main_activity

import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter(mainThreadScheduler: Scheduler, ioThreadScheduler: Scheduler) :
    MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun loadData(){
        viewState.showLoading()
        val disposable: Disposable = weatherRepo.loadWeather(
            city,
            ru.systempla.weatherapp.mvp.presenter.WeatherDataPresenter.OPEN_WEATHER_API_KEY,
            ru.systempla.weatherapp.mvp.presenter.WeatherDataPresenter.METRIC_UNITS,
            language
        )
            .subscribeOn(ioThreadScheduler)
            .observeOn(mainThreadScheduler)
            .subscribe({ model ->
                viewState.setCityName(model.name)
                viewState.setCurrentTemperature(model.main.temp)
                viewState.setHumidity(model.main.humidity)
                viewState.setPressure(model.main.pressure)
                viewState.setWeatherDescription(model.weather.get(0).description)
                viewState.setWeatherIcon(
                    model.weather.get(0).id,
                    model.sys.sunrise * 1000,
                    model.sys.sunset * 1000
                )
                viewState.setWindSpeed(model.wind.speed)
                val disposableSup: Disposable = weatherRepo.loadUVI(
                    ru.systempla.weatherapp.mvp.presenter.WeatherDataPresenter.OPEN_WEATHER_API_KEY,
                    model.coordinates.lat,
                    model.coordinates.lon
                )
                    .subscribeOn(ioThreadScheduler)
                    .observeOn(mainThreadScheduler)
                    .subscribe({ uviRequestRestModel ->
                        viewState.setUVIndex(uviRequestRestModel.uviValue)
                        viewState.hideLoading()
                    }, { t ->
                        viewState.showMessage("ошибка получения UV индекса")
                        viewState.setUVIndex(0)
                        viewState.hideLoading()
                    })
            }, { t ->
                viewState.showMessage("Место не найдено")
                settings.resetSetting()
                viewState.hideLoading()
            })
    }
}