package com.vrajatcreations.tvshows.api

import com.vrajatcreations.tvshows.helper.Constants
import com.vrajatcreations.tvshows.models.TVShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET(Constants.END_POINT)
    suspend fun getAllTVShows(): Response<TVShowResponse>
}