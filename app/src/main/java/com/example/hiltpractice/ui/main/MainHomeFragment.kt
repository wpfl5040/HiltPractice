package com.example.hiltpractice.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.hiltpractice.R
import com.example.hiltpractice.databinding.FragmentMainHomeBinding
import com.example.hiltpractice.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainHomeFragment : BaseFragment<FragmentMainHomeBinding, MainViewModel>(){
    override fun getLayoutRes(): Int = R.layout.fragment_main_home
    override val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            mainViewModel = viewModel
            btnRecycler.setOnClickListener {
                findNavController().navigate(
                    MainHomeFragmentDirections
                        .actionMainHomeFragmentToUserFragment()
                )
            }
        }

    }
}