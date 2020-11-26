package id.erwinpaisal.mentoringweek3.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
// Dibuat oleh : Erwin Paisal
// 21 November 2020

class Config{
    companion object{
        fun getBatikRetrofit(): IndonesiaService{
            val retrofit = Retrofit.Builder()
                .baseUrl("http://batikita.herokuapp.com/index.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(IndonesiaService::class.java)

            return service

        }
        fun getMuseumRetrofit(): IndonesiaService{
            val retrofit = Retrofit.Builder()
                .baseUrl("http://jendela.data.kemdikbud.go.id/api/index.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(IndonesiaService::class.java)

            return service
        }
        fun getCovidData(): IndonesiaService{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://data.covid19.go.id/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(IndonesiaService::class.java)

            return service
        }
        fun getDaerahData(): IndonesiaService{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://dev.farizdotid.com/api/daerahindonesia/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(IndonesiaService::class.java)

            return service
        }



    }
}