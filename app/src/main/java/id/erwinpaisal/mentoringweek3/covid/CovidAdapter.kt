package id.erwinpaisal.mentoringweek3.covid

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.erwinpaisal.mentoringweek3.R
import id.erwinpaisal.mentoringweek3.model.ListDataItem
import kotlinx.android.synthetic.main.item_covid.view.*
import java.text.DecimalFormat
// Dibuat oleh : Erwin Paisal
// 21 November 2020

class CovidAdapter (private val dataCovid:List<ListDataItem?>?):RecyclerView.Adapter<CovidAdapter.CovidViewHolder>(){
    class CovidViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item:ListDataItem?){
            itemView.prov_covid.text = item?.key
            val ribuan = DecimalFormat("#,###")
            val kasus = ribuan.format(item?.jumlahKasus)
            itemView.kasus_covid.text = kasus

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailCovidActivity::class.java)
                intent.putExtra(DetailCovidActivity.EXTRA_COVID, item)
                itemView.context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_covid, parent, false)
        return CovidViewHolder(view)
    }

    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        holder.bindItem(dataCovid?.get(position))
    }

    override fun getItemCount(): Int = dataCovid?.size ?:0
}