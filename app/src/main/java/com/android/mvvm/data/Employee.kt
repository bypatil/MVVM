package com.android.mvvm.data

data class Employee(
    val employee_id: String,
    val full_name: String,
    val email: String,
    val contact_no: String,
    val profile_pic: String
)

data class EmployeeResponse(
    val status: Int,
    val message: String,
    val data: List<Employee>
)