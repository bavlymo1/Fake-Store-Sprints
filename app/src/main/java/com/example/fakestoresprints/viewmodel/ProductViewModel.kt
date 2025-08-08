package com.example.fakestoresprints.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestoresprints.data.Product
import com.example.fakestoresprints.network.RetrofitClient.apiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val _products = MutableStateFlow<Result<List<Product>>>(Result.Loading)
    val products: StateFlow<Result<List<Product>>> = _products

    private val _productDetail = MutableStateFlow<Result<Product>>(Result.Loading)
    val productDetail: StateFlow<Result<Product>> = _productDetail

    init {
        fetchProducts()
    }

    fun fetchProducts(){
        _products.value = Result.Loading
        viewModelScope.launch {
            try {
                val response = apiService.getProducts()
                _products.value = Result.Success(response)
            } catch (e: Exception) {
                _products.value = Result.Error(e)
            }
        }
    }

    fun fetchProductById(id: Int){
        _productDetail.value = Result.Loading
        viewModelScope.launch {
            try {
                val response = apiService.getProductById(id)
                _productDetail.value = Result.Success(response)
                } catch (e: Exception) {
                _productDetail.value = Result.Error(e)
            }
        }
    }
}