package com.marisa.myshop.repository

import com.marisa.myshop.api.ApiClient
import com.marisa.myshop.api.ApiInterface
import com.marisa.myshop.model.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductRepository {
    val apiClient=ApiClient.buildApiClient (ApiInterface::class.java)
    suspend fun getProducts(): Response<ProductResponse>{
        return  withContext(Dispatchers.IO){
            apiClient.getProducts()
        }

    }

}