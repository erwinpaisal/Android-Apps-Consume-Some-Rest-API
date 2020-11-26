package id.erwinpaisal.mentoringweek3.batik

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import id.erwinpaisal.mentoringweek3.R
import id.erwinpaisal.mentoringweek3.model.BatikResponse
import id.erwinpaisal.mentoringweek3.model.HasilItem
import id.erwinpaisal.mentoringweek3.network.Config
import kotlinx.android.synthetic.main.activity_batik.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Dibuat oleh : Erwin Paisal
// 21 November 2020

class BatikActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batik)

        showBatik()
    }


    private fun showBatik() {
        Config.getBatikRetrofit().getBatikData().enqueue(object : Callback<BatikResponse> {
            override fun onResponse(call: Call<BatikResponse>, response: Response<BatikResponse>) {
                if (response.isSuccessful) {
                    showLoading(false)
                    binData(response.body()?.hasil)

                }
            }

            override fun onFailure(call: Call<BatikResponse>, t: Throwable) {
                Log.e("error", t.toString())
            }

        })
    }

    private fun binData(data: List<HasilItem?>?) {
        list_batik.setHasFixedSize(true)
        list_batik.adapter = BatikAdapter(data)
    }

    private fun showLoading(state: Boolean) {
        when (state) {
            true -> progress_batik.visibility = View.VISIBLE
            else -> progress_batik.visibility = View.GONE

        }
    }
}