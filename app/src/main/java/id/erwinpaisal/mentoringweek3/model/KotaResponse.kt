package id.erwinpaisal.mentoringweek3.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
// Dibuat oleh : Erwin Paisal
// 21 November 2020

@Parcelize
data class KotaResponse(

	@field:SerializedName("kota_kabupaten")
	val kotaKabupaten: List<KotaKabupatenItem?>? = null
) : Parcelable

@Parcelize
data class KotaKabupatenItem(

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("id_provinsi")
	val idProvinsi: String? = null
) : Parcelable
