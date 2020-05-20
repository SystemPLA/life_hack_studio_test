package ru.systempla.life_hack_studio_test.main_activity

import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.systempla.life_hack_studio_test.App
import ru.systempla.life_hack_studio_test.R
import ru.systempla.life_hack_studio_test.main_activity.adarter.CompanyRVAdapter

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var unbinder: Unbinder
    private lateinit var adapter: CompanyRVAdapter

    @BindView(R.id.rv)
    lateinit var recyclerView: RecyclerView

    @BindView(R.id.rl_loading)
    lateinit var loadingRelativeLayout: RelativeLayout

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter {
        presenter = MainPresenter(AndroidSchedulers.mainThread(), Schedulers.io())
        App.instance.getApplicationComponent().inject(presenter)
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.getApplicationComponent()
        setContentView(R.layout.activity_main)
        unbinder = ButterKnife.bind(this)
    }

    override fun onDestroy() {
        unbinder.unbind()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        presenter.loadData()
    }

    override fun init() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter =
            CompanyRVAdapter(
                presenter.getCompanyListPresenter()
            )
        recyclerView.adapter = adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun showLoading() {
        loadingRelativeLayout.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loadingRelativeLayout.visibility = View.GONE
    }

    override fun loadImage(avatarUrl: String?) {
        TODO("Not yet implemented")
    }

    override fun showMessage(text: String?) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
