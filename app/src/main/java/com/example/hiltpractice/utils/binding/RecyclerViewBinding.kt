package com.example.hiltpractice.utils.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltpractice.model.response.UserResponseItem
import com.example.hiltpractice.ui.adapter.UserAdapter

object RecyclerViewBinding {

    @JvmStatic
    @BindingAdapter("setAdapter")
    fun setAdapter(view: RecyclerView, adapter: ListAdapter<*,*>){
        view.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("userList")
    fun userList(view: RecyclerView, userList: List<UserResponseItem>){
        if(!userList.isNullOrEmpty()) {
            (view as UserAdapter).submitList(userList)
        }
    }
}