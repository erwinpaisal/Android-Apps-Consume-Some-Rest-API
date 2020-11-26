package id.erwinpaisal.mentoringweek3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.erwinpaisal.mentoringweek3.batik.BatikActivity
import id.erwinpaisal.mentoringweek3.covid.CovidActivity
import id.erwinpaisal.mentoringweek3.daerah.DaerahActivity
import id.erwinpaisal.mentoringweek3.museum.MuseumActivity
import kotlinx.android.synthetic.main.activity_main.*
// Dibuat oleh : Erwin Paisal
// 21 November 2020

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ll_batik.setOnClickListener {
            startActivity(Intent(this, BatikActivity::class.java))
        }
        ll_musium.setOnClickListener {
            startActivity(Intent(this, MuseumActivity::class.java))
        }
        ll_corona.setOnClickListener {
            startActivity(Intent(this, CovidActivity::class.java))
        }
        ll_daerah.setOnClickListener {
            startActivity(Intent(this, DaerahActivity::class.java))
        }


    }
}