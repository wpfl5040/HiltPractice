package com.example.hiltpractice.ui.user

import androidx.databinding.ObservableBoolean
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.example.hiltpractice.model.response.UserResponseItem
import com.example.hiltpractice.repository.UserRepository
import com.example.hiltpractice.ui.base.BaseViewModel

class UserViewModel @ViewModelInject constructor(
    private val userRepository: UserRepository
) : BaseViewModel(){

//    private var _userLiveData: MutableLiveData<Unit> = MutableLiveData()
    private val _toastLiveData: MutableLiveData<String> = MutableLiveData()
    val toastLiveData: LiveData<String> get() = _toastLiveData
    val isLoading: ObservableBoolean = ObservableBoolean(false)

    val userLiveData: LiveData<List<UserResponseItem>?>

    init {
        userLiveData = launchOnViewModelScope {
            isLoading.set(true)
                userRepository.getUserList(
                    onSuccess = { isLoading.set(false) },
                    onError = { _toastLiveData.postValue(it) }
                ).asLiveData()
            }
    }


}


