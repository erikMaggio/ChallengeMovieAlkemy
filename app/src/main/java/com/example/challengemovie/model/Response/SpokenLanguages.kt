package com.example.challengemovie.model.Response

import com.google.gson.annotations.SerializedName

data class SpokenLanguages(
    @SerializedName("iso_639_1") var iso6931: String,
    @SerializedName("name") var name: String,
)