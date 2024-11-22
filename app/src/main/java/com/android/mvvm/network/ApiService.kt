package com.android.mvvm.network

import com.android.mvvm.data.EmployeeResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("0d77f2b0-0f10-4f39-a57a-14f32ec6a10c")
    suspend fun getEmployees(): EmployeeResponse


}