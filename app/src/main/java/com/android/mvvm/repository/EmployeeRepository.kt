package com.android.mvvm.repository

import com.android.mvvm.network.RetrofitClient

class EmployeeRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun fetchEmployees() = apiService.getEmployees()


}