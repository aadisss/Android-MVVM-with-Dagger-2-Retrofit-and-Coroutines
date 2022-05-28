package com.example.daggerexample.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerexample.Model.Product
import com.example.daggerexample.Repository.ProductsRepository
import kotlinx.coroutines.launch

class MainViewModel(private val productsRepository: ProductsRepository) : ViewModel() {

    val products: LiveData<List<Product>>
        get() = productsRepository.products

    init {
        viewModelScope.launch {
            productsRepository.getProducts()
        }
    }
}