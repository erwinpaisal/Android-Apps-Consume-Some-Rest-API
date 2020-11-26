package id.erwinpaisal.mentoringweek3.daerah

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.erwinpaisal.mentoringweek3.R
import id.erwinpaisal.mentoringweek3.model.ProvinsiItem
import kotlinx.android.synthetic.main.item_daerah.view.*
// Dibuat oleh : Erwin Paisal
// 21 November 2020

class DaerahAdapter(private val dataDaerah:List<ProvinsiItem?>?):RecyclerView.Adapter<DaerahAdapter.DaerahViewHolder>() {
    class DaerahViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item:ProvinsiItem?){
            itemView.nama_provinsi.text = item?.nama

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailDaerahActivity::class.java)
                intent.putExtra(DetailDaerahActivity.EXTRA_DAERAH, item)
                itemView.context.startActivity(intent)

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaerahViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_daerah, parent, false)
        return DaerahViewHolder(view)
    }

    override fun onBindViewHolder(holder: DaerahViewHolder, position: Int) {
        holder.bindItem(dataDaerah?.get(position))
    }

    override fun getItemCount(): Int = dataDaerah?.size ?:0

}