package com.example.challengemovie.model.Response

import com.google.gson.annotations.SerializedName

data class PopularResponse(
    @SerializedName("page") var page: Int,
    @SerializedName("results") var result: Array<Movie>,
    @SerializedName("total_results") var total_results: Int,
    @SerializedName("total_pages") var total_pages: Int,
)