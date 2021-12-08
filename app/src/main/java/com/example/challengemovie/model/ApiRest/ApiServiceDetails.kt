package com.example.challengemovie.model.ApiRest

import com.example.challengemovie.model.Response.DetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceDetails {
    @GET("movie/{movie_id}?")
    suspend fun getDetails(
        @Path("movie_id") id: Int,
        @Query("api_key") key: String,
    ): Response<DetailsResponse>
}
