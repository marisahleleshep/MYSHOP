package com.marisa.myshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marisa.myshop.model.Product
import com.marisa.myshop.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel :ViewModel(){
    val productRepository=ProductRepository()
    var productLiveData=MutableLiveData<List<Product>>()
    var errorLiveData=MutableLiveData<String>()

    fun fetchProducts(){
        viewModelScope.launch {
            val response=productRepository.getProducts()
            if (response.isSuccessful){
                productLiveData.postValue((response.body()?.products))
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}