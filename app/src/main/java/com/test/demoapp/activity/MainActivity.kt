package com.test.demoapp.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Visibility
import com.test.demoapp.R
import com.test.demoapp.adapter.ListAdapter
import com.test.demoapp.model.RestaurantResponse
import com.test.demoapp.model.Restaurants
import com.test.demoapp.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : BaseActivity() {
    val name: String = MainActivity::class.java.name
    private lateinit var adapter: ListAdapter


    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initSetup()
    }

    override fun initSetup() {

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        adapter = ListAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

        viewModel.restaurantList.observe(this, Observer { value ->
            shimmer_view_container.stopShimmerAnimation()
            shimmer_view_container.visibility = View.GONE
            recycler_view.visibility = View.VISIBLE
            if (value.restaurants != null && !value.restaurants.isEmpty() &&
                value.restaurants.size > 0
            ) {
                adapter.setListData(value.restaurants)
            } else {
                showToast(resources.getString(R.string.restaurant_not_available))
            }
        })

        btn_search.setOnClickListener {
            hideKeyBoard()
            txt_input_layout.error = ""
            if (edt_category.text.isNullOrEmpty()) {
                txt_input_layout.error = resources.getString(R.string.please_enter_category)
            } else {
                if (verifyAvailableNetwork()) {
                    shimmer_view_container.visibility = View.VISIBLE
                    shimmer_view_container.startShimmerAnimation()
                    recycler_view.visibility = View.GONE
                    viewModel.getListOfDataAPI(edt_category.text.toString())

                } else {
                    showToast(resources.getString(R.string.no_internet))
                }
            }
        }
    }
}