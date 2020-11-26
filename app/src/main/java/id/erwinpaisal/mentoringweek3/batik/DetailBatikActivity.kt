package id.erwinpaisal.mentoringweek3.batik

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.erwinpaisal.mentoringweek3.R
import id.erwinpaisal.mentoringweek3.model.HasilItem
import kotlinx.android.synthetic.main.activity_detail_batik.*
import java.text.NumberFormat
import java.util.*
// Dibuat oleh : Erwin Paisal
// 21 November 2020

class DetailBatikActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_batik)

        val batik = intent.getParcelableExtra<HasilItem>(EXTRA_DATA)
        nama_batik.text = batik?.namaBatik
        asal_batik.text = batik?.daerahBatik
        makna_batik.text = batik?.maknaBatik

        harga_tinggi.text = batik?.hargaTinggi.toString()

        val localeID =  Locale("in", "ID")
        val numberFormat = NumberFormat.getCurrencyInstance(localeID)
        val hargaMin = numberFormat.format(batik?.hargaRendah)
        val hargaMax = numberFormat.format(batik?.hargaTinggi)

        harga_rendah.text = hargaMin
        harga_tinggi.text = hargaMax

        Glide.with(this)
            .load(batik?.linkBatik)
            .into(gambar_batik)
    }
}