package com.test.demoapp.model

import android.widget.RatingBar
import androidx.databinding.BindingAdapter

data class UserRating(val aggregate_rating: String) {

    companion object {
        @JvmStatic
        @BindingAdapter("android:rating")
        fun setRating(view: RatingBar?, rating: String) {
            if (view != null && !rating.isEmpty()) {
                val rate = rating.toFloat()
                view.rating = rate
            }
        }

    }
}