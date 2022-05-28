package com.example.daggerexample.Retrofit

import com.example.daggerexample.Model.Product
import com.example.daggerexample.Utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ProductsApi {

    @GET(Constants.endPointProducts)
    suspend fun getProducts():Response<List<Product>>
}