package com.example.challengemovie.model.Response

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("poster_path") var poster: String?,
    @SerializedName("adult") var adult: Boolean,
    @SerializedName("overview") var overview: String,
    @SerializedName("release_date") var release: String,
    @SerializedName("genre_ids") var genre: Array<Int>,
    @SerializedName("id") var id: Int,
    @SerializedName("original_title") var originalTitle: String,
    @SerializedName("original_language") var language: String,
    @SerializedName("title") var title: String,
    @SerializedName("backdrop_path") var backdrop: String?,
    @SerializedName("popularity") var popularity: Double,
    @SerializedName("vote_count") var voteCount: Int,
    @SerializedName("video") var video: Boolean,
    @SerializedName("vote_average") var vote_average: Double,
)