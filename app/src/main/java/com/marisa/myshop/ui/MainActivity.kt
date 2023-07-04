
package com.marisa.myshop.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.marisa.myshop.databinding.ActivityMainBinding
import com.marisa.myshop.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {
    val productViewModel:ProductViewModel by viewModels()

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        productViewModel.fetchProducts()

        productViewModel.productLiveData.observe(this, Observer { productList->
            Toast.makeText(baseContext,"fetched ${productList?.size}products",Toast.LENGTH_LONG) .show()
            binding.rvDisplayProduct.layoutManager=LinearLayoutManager(this)
            binding.rvDisplayProduct.adapter=ProductAdapter(productList)


        })
        productViewModel.errorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG)
                .show()
        })

    }


}


