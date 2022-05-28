package com.example.daggerexample.di

import com.example.daggerexample.Retrofit.ProductsApi
import com.example.daggerexample.Utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(Constants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesProductApi(retrofit: Retrofit): ProductsApi{
        return retrofit.create(ProductsApi::class.java)
    }
}