package com.example.uasppbkrisnadi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progressBar)
        val btnMenuBeef: Button = findViewById(R.id.btn_beef)
        val btnMenuBreakfast: Button = findViewById(R.id.btn_breakfast)
        val btnMenuChicken: Button = findViewById(R.id.btn_chicken)
        val btnMenuDessert: Button = findViewById(R.id.btn_dessert)
        val btnMenuGoat: Button = findViewById(R.id.btn_goat)
        val btnMenuLamb: Button = findViewById(R.id.btn_lamb)
        val btnMenuPasta: Button = findViewById(R.id.btn_pasta)
        val btnMenuPork: Button = findViewById(R.id.btn_pork)
        val btnMenuSeafood: Button = findViewById(R.id.btn_seafood)
        val btnMenuVegan: Button = findViewById(R.id.btn_vegan)

        btnMenuBeef.setOnClickListener {
            val intent = Intent(this,MenuBeefActivity::class.java)
            startActivity(intent)
        }
        btnMenuBreakfast.setOnClickListener {
            val intent = Intent(this,MenuBreakfastActivity::class.java)
            startActivity(intent)
        }
        btnMenuChicken.setOnClickListener {
            val intent = Intent(this,MenuChickenActivity::class.java)
            startActivity(intent)
        }
        btnMenuDessert.setOnClickListener {
            val intent = Intent(this,MenuDessertActivity::class.java)
            startActivity(intent)
        }
        btnMenuGoat.setOnClickListener {
            val intent = Intent(this,MenuGoatActivity::class.java)
            startActivity(intent)
        }
        btnMenuLamb.setOnClickListener {
            val intent = Intent(this,MenuLambActivity::class.java)
            startActivity(intent)
        }
        btnMenuPasta.setOnClickListener {
            val intent = Intent(this,MenuPastaActivity::class.java)
            startActivity(intent)
        }
        btnMenuPork.setOnClickListener {
            val intent = Intent(this,MenuPorkActivity::class.java)
            startActivity(intent)
        }
        btnMenuSeafood.setOnClickListener {
            val intent = Intent(this,MenuSeafoodActivity::class.java)
            startActivity(intent)
        }
        btnMenuVegan.setOnClickListener {
            val intent = Intent(this,MenuVeganActivity::class.java)
            startActivity(intent)
        }
    }
}