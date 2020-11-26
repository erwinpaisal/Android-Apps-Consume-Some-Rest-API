package id.erwinpaisal.mentoringweek3.covid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.erwinpaisal.mentoringweek3.R
import id.erwinpaisal.mentoringweek3.model.ListDataItem
import kotlinx.android.synthetic.main.covid_case_card.*
import kotlinx.android.synthetic.main.covid_header.*
import java.text.DecimalFormat
// Dibuat oleh : Erwin Paisal
// 21 November 2020

class DetailCovidActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_COVID ="extra_covid"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_covid)

        val ribuan = DecimalFormat("#,###")
        val covid = intent.getParcelableExtra<ListDataItem>(EXTRA_COVID)
        propinsi_covid.text = covid?.key

        val kasusProv = ribuan.format(covid?.jumlahKasus)
        jumlah_kasus_prov.text = "$kasusProv orang"
        val kasusSembuh = ribuan.format(covid?.jumlahSembuh)
        kasus_sembuh.text = "$kasusSembuh orang"
        val kasusMeninggal = ribuan.format(covid?.jumlahMeninggal)
        kasus_meninggal.text = "$kasusMeninggal orang"

        val kasusDirawat = ribuan.format(covid?.jumlahDirawat)
        kasus_rawat.text = "$kasusDirawat orang"





    }
}