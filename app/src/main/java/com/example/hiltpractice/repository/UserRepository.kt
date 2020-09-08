package com.example.hiltpractice.repository

import androidx.annotation.WorkerThread
import com.example.hiltpractice.api.client.UserClient
import com.skydoves.sandwich.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userClient: UserClient
) {
    @WorkerThread
    suspend fun getUserList(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val response = userClient.getUserList()
        response.suspendOnSuccess {
            emit(data)
            onSuccess()
        }
            // handle the case when the API request gets an error response.
            // e.g. internal server error.
            .onError {
                onError(message())
            }
            // handle the case when the API request gets an exception response.
            // e.g. network connection error.
            .onException {
                onError(message())
            }
    }.flowOn(Dispatchers.IO)
}