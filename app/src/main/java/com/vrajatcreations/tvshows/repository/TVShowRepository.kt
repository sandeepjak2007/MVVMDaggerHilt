package com.vrajatcreations.tvshows.repository

import com.vrajatcreations.tvshows.api.APIService
import javax.inject.Inject

class TVShowRepository
@Inject constructor(private val apiService: APIService) {
    suspend fun getTVShows() = apiService.getAllTVShows()
}