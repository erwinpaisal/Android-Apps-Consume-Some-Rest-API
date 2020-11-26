package id.erwinpaisal.mentoringweek3.museum

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.erwinpaisal.mentoringweek3.R
import id.erwinpaisal.mentoringweek3.model.DataItem
import kotlinx.android.synthetic.main.item_museum.view.*
// Dibuat oleh : Erwin Paisal
// 21 November 2020

class MuseumAdapter(private val dataMuseum:List<DataItem?>?):RecyclerView.Adapter<MuseumAdapter.MuseumViewHolder>() {
    class MuseumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item:DataItem?){
            itemView.nama_museum.text = item?.nama
            itemView.nama_kota.text = item?.kabupatenKota

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailMuseumActivity::class.java)
                intent.putExtra(DetailMuseumActivity.EXTRA_MUSEUM, item)
                itemView.context.startActivity(intent)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_museum, parent, false)
        return MuseumViewHolder(view)
    }

    override fun onBindViewHolder(holder: MuseumViewHolder, position: Int) {
        holder.bindItem(dataMuseum?.get(position))
    }

    override fun getItemCount(): Int = dataMuseum?.size ?:0
}