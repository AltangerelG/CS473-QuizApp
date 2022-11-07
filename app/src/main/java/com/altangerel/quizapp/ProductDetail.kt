package com.altangerel.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val currentProduct = intent.getSerializableExtra("PRODUCT") as Product

        supportActionBar?.title = currentProduct.title

        productImage.setImageResource(currentProduct.image)
        productTitle.text = currentProduct.title
        productColor.text = "Color: ${currentProduct.color}"
        productId.text = "Amazon product id: ${currentProduct.itemId}"
        productDesc.text = "Item description: ${currentProduct.desc}"
    }
}