package com.android.mvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.mvvm.data.Employee
import com.android.mvvm.repository.EmployeeRepository
import kotlinx.coroutines.launch

class EmployeeViewModel: ViewModel() {

    private val repository = EmployeeRepository()

    private val _employees = MutableLiveData<List<Employee>>()
    val employees: LiveData<List<Employee>> = _employees

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun fetchEmployees() {
        _loading.value = true
        viewModelScope.launch {
            try {
                val response = repository.fetchEmployees()
                if (response.status == 1) {
                    _employees.value = response.data
                } else {
                    _error.value = response.message
                }
            } catch (e: Exception) {
                _error.value = "Failed to load data: ${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }

}