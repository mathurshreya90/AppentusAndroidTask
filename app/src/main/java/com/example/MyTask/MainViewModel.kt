package com.example.MyTask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    var     UrlList = MutableLiveData<List<GetUrl>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllUrls() {

        val response = repository.getAllUrl()
        response.enqueue(object : Callback<List<GetUrl>> {
            override fun onResponse(call: Call<List<GetUrl>>, response: Response<List<GetUrl>>) {
                UrlList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<GetUrl>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}