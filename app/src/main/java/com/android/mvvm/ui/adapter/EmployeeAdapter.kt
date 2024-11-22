package com.android.mvvm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.mvvm.R
import com.android.mvvm.data.Employee
import com.android.mvvm.databinding.ItemEmployeeBinding
import com.bumptech.glide.Glide

class EmployeeAdapter(private val employees: List<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    class EmployeeViewHolder(val binding: ItemEmployeeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val binding = ItemEmployeeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employees[position]
        with(holder.binding) {
            tvName.text = employee.full_name
            tvEmail.text = employee.email
            tvContact.text = employee.contact_no
            Glide.with(ivProfile.context)
                .load(employee.profile_pic)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(ivProfile)
        }
    }

    override fun getItemCount(): Int = employees.size
}