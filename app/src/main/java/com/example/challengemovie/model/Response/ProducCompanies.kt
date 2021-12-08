package com.example.challengemovie.model.Response

import com.google.gson.annotations.SerializedName

data class ProducCompanies(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("logo_path") var logoPath: String?,
    @SerializedName("origin_country") var originCountry: String
)