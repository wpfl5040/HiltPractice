package com.example.hiltpractice.ui.base

import androidx.lifecycle.*
import com.example.hiltpractice.ui.ViewModelDelegate
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


open class BaseViewModel : ViewModel(){
    val coroutineIoContext = viewModelScope.coroutineContext + Dispatchers.IO

    inline fun <T> launchOnViewModelScope(crossinline block: suspend () -> LiveData<T>): LiveData<T> {
        return liveData(coroutineIoContext) {
            emitSource(block())
        }
    }

}