package com.example.daggerexample.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import com.example.daggerexample.Repository.ProductsRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val productsRepository: ProductsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(productsRepository) as T
    }
}