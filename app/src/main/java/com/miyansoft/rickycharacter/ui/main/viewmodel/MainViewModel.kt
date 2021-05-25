package com.miyansoft.rickycharacter.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.miyansoft.rickycharacter.data.model.Response
import com.miyansoft.rickycharacter.data.model.User
import com.miyansoft.rickycharacter.data.repository.MainRepository
import com.miyansoft.rickycharacter.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    // replaced getUsers with kotlin design getters
    val users
        // used mutableLiveData so that we fetch data in another scope
        get() = MutableLiveData<Resource<Response?>>().apply {

            // set initial value
            value = Resource.loading(data = null)

            val mT = this

            mainRepository.getUsers().enqueue(
                object : Callback<Response> {
                    override fun onResponse(
                        call: Call<Response>,
                        response: retrofit2.Response<Response>
                    ) {
                        // on success we update with response
                        mT.value = Resource.success(data = response.body())
                    }

                    override fun onFailure(call: Call<Response>, t: Throwable) {
                        // on failure we update with error response
                        mT.value = Resource.error(data = null, message = t.message ?: "Error message")
                    }

                }
            )

        }


}