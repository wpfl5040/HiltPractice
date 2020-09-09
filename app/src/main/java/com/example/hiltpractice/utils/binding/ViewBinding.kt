package com.example.hiltpractice.utils.binding

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.hiltpractice.ext.toast

object ViewBinding {

    @BindingAdapter("toast")
    @JvmStatic
    fun bindToast(view: View, text: String?) {
        if(!text.isNullOrBlank()) toast(view.context, text, 0)
    }

    @BindingAdapter("glideImage")
    @JvmStatic
    fun bindLoadImage(view: AppCompatImageView, url: String) {
        Glide.with(view)
            .load(url)
            .apply(RequestOptions.centerCropTransform())
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }

    @BindingAdapter("goneUnless")
    @JvmStatic
    fun goneUnless(view: View, visible: Boolean){
        view.visibility = if(visible) View.VISIBLE else View.GONE
    }

}