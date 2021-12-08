package com.example.challengemovie.model.repository
import com.example.challengemovie.model.ApiRest.ApiServicePopular
import com.example.challengemovie.model.Response.PopularResponse
import retrofit2.Response
import javax.inject.Inject

class PopularRepository @Inject constructor(val apiPopular: ApiServicePopular) {

    suspend fun getPopular(page: Int): Response<PopularResponse> {
        return apiPopular.getPopular("eaf0441b0b9b8e6e41273b54db68a1aa", page)
    }
}