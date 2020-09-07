package com.example.hiltpractice.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hiltpractice.ext.Event
import javax.inject.Inject

interface ViewModelDelegate {
    val toastObservable: LiveData<Event<Int>>
    val backBtnEvent: LiveData<Event<Unit>>
    fun showToast(textRes: Int)
    fun pressBackBtn()
}

class ViewModelDelegateImp @Inject constructor(

) : ViewModelDelegate{
    override val toastObservable = MutableLiveData<Event<Int>>()

    private val _backBtnEvent = MutableLiveData<Event<Unit>>()
    override val backBtnEvent : LiveData<Event<Unit>> get() = _backBtnEvent

    override fun showToast(textRes: Int) {
        toastObservable.value = Event(textRes)
    }

    override fun pressBackBtn() {
        _backBtnEvent.value = Event(Unit)
    }

}