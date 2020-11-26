package id.erwinpaisal.mentoringweek3.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
// Dibuat oleh : Erwin Paisal
// 21 November 2020

@Parcelize
data class ProvinsiResponse(

    @field:SerializedName("provinsi")
    val provinsi: List<ProvinsiItem?>? = null
) : Parcelable

@Parcelize
data class ProvinsiItem(

    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
) : Parcelable
