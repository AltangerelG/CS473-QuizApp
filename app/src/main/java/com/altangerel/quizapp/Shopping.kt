package com.altangerel.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class Shopping : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        supportActionBar?.title = "Shop by Category"
    }

    fun startElectronicsDetail(type: String) {
        val electronicsIntent = Intent(this, Electronics::class.java)
        electronicsIntent.putExtra("TYPE", type)
        startActivity(electronicsIntent)
    }

    private fun alert(text: String) {
        Toast.makeText(applicationContext, "You have chosen the $text category of shopping", Toast.LENGTH_SHORT).show()
    }

    fun onClick(v: View?) {
        when (v?.id) {
            R.id.electronic -> startElectronicsDetail(getString(R.string.str_electronic))
            R.id.clothing -> alert(getString(R.string.str_clothes))
            R.id.beauty -> alert(getString(R.string.str_beauty))
            R.id.food -> alert(getString(R.string.str_food))
            else -> alert("Nothing")
        }
    }
}