package com.marisa.myshop.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marisa.myshop.model.Product
import com.marisa.myshop.databinding.ProductsListBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation



class ProductAdapter (var products:List<Product>): RecyclerView.Adapter<ProductAdapter.ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding =
            ProductsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val currentProduct = products.get(position)
        val binding = holder.binding

                binding.tvId.text=currentProduct.id.toString()
                binding.tvBrand .text=currentProduct.brand.toString()
                binding. tvCategory.text=currentProduct.category
                binding. tvPrice.text=currentProduct.price.toString()
               binding. tvRating.text=currentProduct.rating.toString()
               binding. tvTitle.text=currentProduct.title
               binding. tvStock.text=currentProduct.stock.toString()
               binding. tvThumbNail.text=currentProduct.stock.toString()
               binding. tvDescription.text=currentProduct.description


        Picasso
            .get().load(currentProduct.thumbnail)
            .resize(80, 80)
            .centerInside()
            .transform(CropCircleTransformation())
            .into(binding.ivAvatar)
    }


    override fun getItemCount(): Int {
        return products.size

    }

    class ProductsViewHolder(var binding:ProductsListBinding) : RecyclerView.ViewHolder(binding.root)
}







