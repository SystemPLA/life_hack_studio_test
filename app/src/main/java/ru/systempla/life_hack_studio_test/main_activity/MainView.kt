package ru.systempla.life_hack_studio_test.main_activity

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import moxy.MvpView

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface MainView : MvpView{
    fun init()
    fun updateList()
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showMessage(text: String?)

    fun showLoading()
    fun hideLoading()

    fun loadImage(avatarUrl: String?)
}