package ru.systempla.life_hack_studio_test.main_activity

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

@AddToEndSingle
interface MainView : MvpView{

    fun init()
    fun updateList()
    fun showLoading()
    fun hideLoading()
    fun loadImage(avatarUrl: String?)

    @OneExecution
    fun showMessage(text: String?)
}