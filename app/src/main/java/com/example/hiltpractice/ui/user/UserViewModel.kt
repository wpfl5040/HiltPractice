package com.example.hiltpractice.ui.user

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.hiltpractice.model.response.UserResponseItem
import com.example.hiltpractice.repository.UserRepository
import com.example.hiltpractice.ui.base.BaseViewModel

class UserViewModel @ViewModelInject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {
//    private var _userLiveData: MutableLiveData<Unit> = MutableLiveData()
//    val corouContext = viewModelScope.coroutineContext + Dispatchers.IO

    val userLiveData: LiveData<List<UserResponseItem>?>

    init {
        userLiveData = launchOnViewModelScope {
            Log.d("//testtest", "test")
                userRepository.getUserList(
                    onSuccess = { Log.d("//userViewModel", "success")},
                    onError = { Log.d("//userViewModel", it) }
                ).asLiveData()
            }
        }


}


