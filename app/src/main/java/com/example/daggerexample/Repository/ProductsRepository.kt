package com.example.daggerexample.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daggerexample.Model.Product
import com.example.daggerexample.Retrofit.ProductsApi
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val productsApi: ProductsApi) {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    suspend fun getProducts()
    {
        val results = productsApi.getProducts()
        if(results.isSuccessful && results.body() != null){
            _products.postValue(results.body())
        }
    }

}