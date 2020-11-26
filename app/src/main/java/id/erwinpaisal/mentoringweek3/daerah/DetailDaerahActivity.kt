package id.erwinpaisal.mentoringweek3.daerah

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import id.erwinpaisal.mentoringweek3.R
import id.erwinpaisal.mentoringweek3.daerah.subdaerah.SubDaerahAdapter
import id.erwinpaisal.mentoringweek3.model.KotaKabupatenItem
import id.erwinpaisal.mentoringweek3.model.KotaResponse
import id.erwinpaisal.mentoringweek3.model.ProvinsiItem
import id.erwinpaisal.mentoringweek3.network.Config
import kotlinx.android.synthetic.main.activity_detail_daerah.*
import kotlinx.android.synthetic.main.daerah_header.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
// Dibuat oleh : Erwin Paisal
// 21 November 2020

class DetailDaerahActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DAERAH = "extra_daerah"
    }

    private lateinit var daerah: ProvinsiItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_daerah)


        daerah = intent.getParcelableExtra<ProvinsiItem>(EXTRA_DAERAH) as ProvinsiItem
        propinsi_nama.text = daerah.nama
        showDaerah()
    }

    private fun showDaerah() {
        Config.getDaerahData().getCityByProvince(daerah.id)
            .enqueue(object : Callback<KotaResponse> {
                override fun onResponse(
                    call: Call<KotaResponse>,
                    response: Response<KotaResponse>
                ) {

                    if (response.isSuccessful) {
                        showLoading(false)
                        binData(response.body()?.kotaKabupaten)
                    }
                }

                override fun onFailure(call: Call<KotaResponse>, t: Throwable) {
                    Log.e("error", t.message.toString())
                }

            })
    }

    private fun binData(data: List<KotaKabupatenItem?>?) {
        list_kota.setHasFixedSize(true)
        list_kota.adapter = SubDaerahAdapter(data)
    }

    private fun showLoading(state: Boolean) {
        when (state) {
            true -> progress_kota.visibility = View.VISIBLE
            else -> progress_kota.visibility = View.GONE

        }
    }
}