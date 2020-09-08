package com.example.hiltpractice.ui.user

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.hiltpractice.R
import com.example.hiltpractice.databinding.FragmentUserBinding
import com.example.hiltpractice.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : BaseFragment<FragmentUserBinding, UserViewModel>(){
    override fun getLayoutRes(): Int = R.layout.fragment_user
    override val viewModel: UserViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            userViewModel = viewModel
        }

        viewModel.userLiveData.observing {

        }


    }
}