package com.altangerel.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class Electronics : AppCompatActivity(), RecyclerViewAdapter.ItemClickListener {
    val products = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        supportActionBar?.title = "Electronics"

        products.add(Product("SAMSUNG Galaxy Tab S6", 264.00, "Angora Blue, " +
                "Chiffon Rose & Oxford Gray", R.drawable.image1, "#1667798693", "The" +
                " included S Pen makes it easier than ever to write notes and personalize photos" +
                " and videos, all without needing to charge. The S Pen attaches magnetically " +
                "right to your tablet so you can quickly put it down and pick it back up without " +
                "losing it"))
        products.add(Product("2022 Apple MacBook Pro Laptop with M2 chip", 1399.00,
            "Space Gray & Silver", R.drawable.image2, "#1667799206", "13-inch " +
                    "Retina Display, 8GB RAM, 512GB SSD Storage, Touch Bar, Backlit Keyboard, " +
                    "FaceTime HD Camera. Works with iPhone and iPad; Silver"))
        products.add(Product("SAMSUNG 65-Inch Class Neo QLED 4K", 1397.99, "Black",
            R.drawable.image3, "#1667799463", "QN85B Series Mini LED Quantum HDR 24x,"+
                    " Dolby Atmos, Object Tracking Sound, Motion Xcelerator Turbo+ Smart TV with" +
                    " Alexa Built-In (QN65QN85BAFXZA, 2022 Model)"))
        products.add(Product("HP DeskJet 2755e", 84.89, "White",
            R.drawable.image4, "#1667799613", "Wireless Color All-in-One Printer with"+
                    " Bonus 6 Months Instant Ink with HP+"))

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerViewAdapter(products, this)
        recyclerView.adapter = adapter

    }

    override fun onItemClick(position: Int) {
        val detailIntent = Intent(applicationContext, ProductDetail::class.java)
        detailIntent.putExtra("PRODUCT", products[position])
        startActivity(detailIntent)
    }
}