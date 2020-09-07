package com.example.hiltpractice.ui.main


import android.os.Bundle
import androidx.activity.viewModels
import com.example.hiltpractice.R
import com.example.hiltpractice.databinding.ActivityMainBinding
import com.example.hiltpractice.ui.base.BaseActivity
import com.example.hiltpractice.ext.setToastObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun getLayoutRes(): Int = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(viewModel){
            delegate.backBtnEvent.eventObserving { onBackPressed() }
            setToastObserver(toastObservable)
        }
    }
}