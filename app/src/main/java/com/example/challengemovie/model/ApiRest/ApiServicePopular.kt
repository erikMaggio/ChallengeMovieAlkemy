package com.example.challengemovie.model.ApiRest

import com.example.challengemovie.model.Response.PopularResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServicePopular {
    @GET("movie/popular?")

    suspend fun getPopular(
        @Query("api_key") key: String,
        @Query("page") page: Int
    ): Response<PopularResponse>
}