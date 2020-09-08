package com.example.controle

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object BindingAdapterUser {


    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun setImageUrl(iv: ImageView, imageUrl: String?) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.color.colorAccent)

        Glide
            .with(iv.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(imageUrl)
            .centerCrop()
            .into(iv)
    }

}
