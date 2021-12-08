package com.example.challengemovie.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengemovie.model.Response.DetailsResponse
import com.example.challengemovie.model.repository.DetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(val detailsRepository: DetailsRepository) : ViewModel() {

    var liveData = MutableLiveData<DetailsResponse>()

    fun getDetails(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = detailsRepository.getDetails(id)
            if (call.isSuccessful) {
                liveData.postValue(call.body())
            }
        }
    }
}