package com.example.hiltpractice.di

import com.example.hiltpractice.ui.ViewModelDelegate
import com.example.hiltpractice.ui.ViewModelDelegateImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class delegateModule {

    @Binds
    abstract fun bindViewModelDelegate(
        delegateImp: ViewModelDelegateImp
    ) : ViewModelDelegate

}