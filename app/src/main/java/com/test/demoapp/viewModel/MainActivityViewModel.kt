package com.test.demoapp.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.test.demoapp.model.RestaurantResponse
import com.test.demoapp.webService.IApiInterface
import com.test.demoapp.webService.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewModel(app: Application) : AndroidViewModel(app) {

    internal var restaurantList = MutableLiveData<RestaurantResponse>()

    fun getListOfDataAPI(cityName: String) {
        val call =
            RetrofitClient.client?.create(IApiInterface::class.java)?.getRestaurantList(cityName)

        call?.enqueue(object : Callback<RestaurantResponse> {
            override fun onResponse(
                call: Call<RestaurantResponse>,
                response: Response<RestaurantResponse>
            ) {
                Log.e("response is", "==>" + response.body().toString())
                response.body()?.let {
                    restaurantList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<RestaurantResponse>, t: Throwable) {
                Log.e("failiure is", "==>" + t.message)
                restaurantList.postValue(MutableLiveData<RestaurantResponse>().value)
            }
        })
    }
}