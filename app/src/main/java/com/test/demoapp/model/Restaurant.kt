package com.test.demoapp.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


data class Restaurant(
    val url: String, val cuisines: String, val phone_numbers: String,
    val name: String, val location: Location, val timings: String,
    val currency: String, val thumb: String, val user_rating: UserRating
) {

    companion object {
        @BindingAdapter("thumbImage")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String?) {
            Glide.with(view.getContext())
                .load(imageUrl)
                .asBitmap()
                .centerCrop()
                .into(view)
        }
    }
}