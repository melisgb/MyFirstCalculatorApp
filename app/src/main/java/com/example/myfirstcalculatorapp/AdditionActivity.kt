//Tutorial https://www.youtube.com/watch?v=dFlPARW5IX8&list=PLY_ZW4F4wPwTApfo0tVFtj97cZxFNFlEs&index=3&t=0s
package com.example.myfirstcalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class AdditionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addition)

        val addBtn = findViewById<Button>(R.id.addBtn)
        val firstNumEditText = findViewById<EditText>(R.id.firstNumEditText)
        val secondNumEditText = findViewById<EditText>(R.id.secondNumEditText)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)


//        every time the button is clicked, do this:
        addBtn.setOnClickListener{
            //            val secondN : Int
            val firstN : String = firstNumEditText.text.toString()
            val secondN : String = secondNumEditText.text.toString()
            val result : Int = firstN.toInt() + secondN.toInt()
            resultTextView.setText(result.toString()+"")
//            Toast.makeText(this, firstN, Toast.LENGTH_SHORT).show()

        }



    }
}
