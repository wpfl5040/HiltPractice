package com.example.hiltpractice.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.hiltpractice.R
import com.example.hiltpractice.ui.ViewModelDelegate
import com.example.hiltpractice.ui.base.BaseViewModel

class MainViewModel @ViewModelInject constructor(
    val delegate: ViewModelDelegate
) : BaseViewModel(),
    ViewModelDelegate by delegate{

}