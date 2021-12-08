package com.example.challengemovie.model.repository

import com.example.challengemovie.model.ApiRest.ApiServiceDetails
import com.example.challengemovie.model.Response.DetailsResponse
import retrofit2.Response
import javax.inject.Inject

class DetailsRepository @Inject constructor(val apiServiceDetails: ApiServiceDetails) {

    suspend fun getDetails(id: Int): Response<DetailsResponse> {
        return apiServiceDetails.getDetails(id, "eaf0441b0b9b8e6e41273b54db68a1aa")
    }
}