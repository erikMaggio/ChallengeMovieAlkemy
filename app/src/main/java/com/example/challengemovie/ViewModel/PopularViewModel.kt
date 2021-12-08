package com.example.challengemovie.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengemovie.model.repository.PopularRepository
import com.example.challengemovie.model.Response.PopularResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor(val popularRepository : PopularRepository) : ViewModel() {

    var listLiveData = MutableLiveData<PopularResponse>()


    fun getPopular(page:Int){
        CoroutineScope(Dispatchers.IO).launch {
            val call = popularRepository.getPopular(page)

            if (call.isSuccessful){
                listLiveData.postValue(call.body())
            }
        }
    }


}