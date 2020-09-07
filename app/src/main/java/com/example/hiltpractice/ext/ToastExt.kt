package com.example.hiltpractice.ext

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import com.example.hiltpractice.ui.base.BaseActivity

fun BaseActivity<*, *>.setToastObserver(liveData: LiveData<Event<Int>>){
    liveData.eventObserving{ toast(it) }
}

fun Context.toast(text: String, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, text, duration).show()
fun Context.toast(@StringRes id: Int, duration: Int = Toast.LENGTH_SHORT) = toast(getString(id), duration)

fun Any.toast(context: Context, content: String, duration: Int = Toast.LENGTH_SHORT) {
    context.toast(content, duration)
}

fun Any.toast(context: Context, @StringRes id: Int, duration: Int=Toast.LENGTH_SHORT) {
    context.toast(id, duration)
}
