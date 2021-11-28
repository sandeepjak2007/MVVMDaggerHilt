package com.vrajatcreations.tvshows.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vrajatcreations.tvshows.models.TVShowItem
import com.vrajatcreations.tvshows.repository.TVShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TVShowViewModel
@Inject
constructor(private val repository: TVShowRepository) : ViewModel() {
    private val _response = MutableLiveData<List<TVShowItem>>()

    val responseTVShow: LiveData<List<TVShowItem>>
        get() = _response

    init {
        getAllTVShows()
    }

    private fun getAllTVShows() = viewModelScope.launch {
        repository.getTVShows().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("TVViewModel", "getAllTVShows: ${response.code()}")
            }
        }
    }
}