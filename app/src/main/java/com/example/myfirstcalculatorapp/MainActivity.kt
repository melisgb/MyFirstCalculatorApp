package com.example.myfirstcalculatorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toAdditionActivityBtn = findViewById<Button>(R.id.toAdditionActButton)
        toAdditionActivityBtn.setOnClickListener{
            val intent = Intent(this, AdditionActivity::class.java)
            startActivity(intent)
        }

        val toSliderActivityBtn = findViewById<Button>(R.id.toSliderActButton)
        toSliderActivityBtn.setOnClickListener{
            val intent = Intent(this, SliderActivity::class.java)
            startActivity(intent)
        }


        val toCalculatorActivity = findViewById<Button>(R.id.toCalcActButton)
        toCalculatorActivity.setOnClickListener{
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

    }
}
