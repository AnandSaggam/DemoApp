package com.test.demoapp.model

data class RestaurantResponse(
    val results_found: String, val results_shown: String,
    val restaurants: ArrayList<Restaurants>, val results_start: String
) {
}