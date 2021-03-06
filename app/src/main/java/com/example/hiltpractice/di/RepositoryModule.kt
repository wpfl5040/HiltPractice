package com.example.hiltpractice.di

import com.example.hiltpractice.api.client.UserClient
import com.example.hiltpractice.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideUserRepository(
        userClient: UserClient
    ): UserRepository {
        return UserRepository(userClient)
    }


}