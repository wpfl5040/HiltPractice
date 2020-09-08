package com.example.hiltpractice.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.hiltpractice.databinding.RowUserBinding
import com.example.hiltpractice.model.response.UserResponseItem
import com.example.hiltpractice.ui.base.BaseAdapter

class UserAdapter : BaseAdapter<UserResponseItem, RowUserBinding>(
    object : DiffUtil.ItemCallback<UserResponseItem>(){
        override fun areContentsTheSame(
            oldItem: UserResponseItem,
            newItem: UserResponseItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(
            oldItem: UserResponseItem,
            newItem: UserResponseItem
        ): Boolean {
            return oldItem == newItem
        }
    }
) {
    override val layoutRes: Int = com.example.hiltpractice.R.layout.row_user
    override fun onBindViewHolder(binding: RowUserBinding, item: UserResponseItem) {
        binding.user = item
    }
}