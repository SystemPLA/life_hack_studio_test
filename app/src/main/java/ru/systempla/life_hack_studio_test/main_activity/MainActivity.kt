package ru.systempla.life_hack_studio_test.main_activity

import android.os.Bundle
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import ru.systempla.life_hack_studio_test.App
import ru.systempla.life_hack_studio_test.R
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.getApplicationComponent()
        setContentView(R.layout.activity_main)
    }

    override fun init() {
        TODO("Not yet implemented")
    }

    override fun updateList() {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun loadImage(avatarUrl: String?) {
        TODO("Not yet implemented")
    }

    override fun showMessage(text: String?) {
        TODO("Not yet implemented")
    }
}
