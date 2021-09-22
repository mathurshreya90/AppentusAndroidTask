package com.example.MyTask

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllUrl() = retrofitService.getAllUrl()
}