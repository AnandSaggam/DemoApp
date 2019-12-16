package com.test.demoapp.webService

import com.test.demoapp.model.RestaurantResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface IApiInterface {


    @Headers("user-key: 4feaa2167c4dc6beadf629319423bd4b")
    @GET("search")
    fun getRestaurantList(@Query("city") limit: String
    ): Call<RestaurantResponse>;

}