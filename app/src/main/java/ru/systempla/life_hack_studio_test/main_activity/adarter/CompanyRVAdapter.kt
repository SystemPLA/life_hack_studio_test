package ru.systempla.life_hack_studio_test.main_activity.adarter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.functions.Function
import ru.systempla.life_hack_studio_test.R
import ru.systempla.life_hack_studio_test.main_activity.CompanyItemView

class CompanyRVAdapter(private val presenter : ICompanyListPresenter) : RecyclerView.Adapter<CompanyRVAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_company, parent, false))

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        presenter.bind(holder)
        RxView.clicks(holder.itemView)
            .map(
                Function { o: Any? -> holder }
            ).subscribe(presenter.getClickSubject())
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), CompanyItemView {

        init {
            ButterKnife.bind(this, itemView)
        }

        var pos : Int = 0

        @BindView(R.id.imageView)
        lateinit var rvIconIV: ImageView

        @BindView(R.id.tv_title)
        lateinit var rvDateTimeTV: TextView

        override fun getPos(): Int {
            return pos
        }
    }



}
