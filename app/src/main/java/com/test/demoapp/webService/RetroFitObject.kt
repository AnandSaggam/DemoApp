package com.test.demoapp.webService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val BASE_URL = "https://developers.zomato.com/api/v2.1/"

    private var retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val client: Retrofit?
        get() {

            return retrofit
        }

    fun getRetro(): Retrofit? {
        return retrofit
    }
}