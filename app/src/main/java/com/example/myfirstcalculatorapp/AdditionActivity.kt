//Tutorial https://www.youtube.com/watch?v=dFlPARW5IX8&list=PLY_ZW4F4wPwTApfo0tVFtj97cZxFNFlEs&index=3&t=0s
package com.example.myfirstcalculatorapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.view.*
import android.view.inputmethod.InputMethodManager

class AdditionActivity : AppCompatActivity() {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }

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

            if(firstNumEditText.text.length > 0 && secondNumEditText.text.length > 0 )
            {
                val result : Int = firstN.toInt() + secondN.toInt()
                resultTextView.setText(result.toString()+"")
            }
            else {
                resultTextView.setText("-")
            }
//            Toast.makeText(this, firstN, Toast.LENGTH_SHORT).show()

        }


    }
}
