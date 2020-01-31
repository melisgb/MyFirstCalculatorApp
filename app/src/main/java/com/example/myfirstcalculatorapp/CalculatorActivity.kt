// Tutorial from https://www.youtube.com/watch?v=EpP6KgJtHTk&list=PLY_ZW4F4wPwTApfo0tVFtj97cZxFNFlEs&index=4&t=0s
package com.example.myfirstcalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        //Numbers
        oneTxtView.setOnClickListener {appendOnExpression("1", true)}
        twoTxtView.setOnClickListener {appendOnExpression("2", true)}
        threeTxtView.setOnClickListener {appendOnExpression("3", true)}
        fourTxtView.setOnClickListener {appendOnExpression("4", true)}
        fiveTxtView.setOnClickListener {appendOnExpression("5", true)}
        sixTxtView.setOnClickListener {appendOnExpression("6", true)}
        sevenTxtView.setOnClickListener {appendOnExpression("7", true)}
        eightTxtView.setOnClickListener {appendOnExpression("8", true)}
        nineTxtView.setOnClickListener {appendOnExpression("9", true)}
        zeroTxtView.setOnClickListener {appendOnExpression("0", true)}
        dotTxtView.setOnClickListener {appendOnExpression(".", true)}

        //Expressions
        additionTxtView.setOnClickListener {appendOnExpression("+", false)}
        substractTxtView.setOnClickListener {appendOnExpression("-", false)}
        multiplyTxtView.setOnClickListener {appendOnExpression("*", false)}
        divideTxtView.setOnClickListener {appendOnExpression("/", false)}
        openParenTxtView.setOnClickListener {appendOnExpression("(", false)}
        closeParenTxtView.setOnClickListener {appendOnExpression(")", false)}
        equalTxtView.setOnClickListener {appendOnExpression("=", false)}

        clearTxtView.setOnClickListener {
            screenResultTxtView.text =""
            screenExpressionTxtView.text =""
        }

        backTxtView.setOnClickListener {
            val screenStr = screenExpressionTxtView.text.toString()
            if(screenStr.isNotEmpty()){
                screenExpressionTxtView.text = screenStr.substring(0, screenStr.length-1)
            }

            screenResultTxtView.text = ""
        }

        equalTxtView.setOnClickListener {
            try {
                val expression = ExpressionBuilder(screenExpressionTxtView.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()

                if(result == longResult.toDouble())
                    screenResultTxtView.text = longResult.toString()
                else
                    screenResultTxtView.text = result.toString()
            }
            catch(e:Exception){
                Log.d("Exception"," message : " + e.message)
            }
        }
    }


    fun appendOnExpression(string: String, canClear : Boolean){
        //if there are results already, then clear the expression screen
        if(screenResultTxtView.text.isNotEmpty())
            screenExpressionTxtView.text = ""

        if(canClear){
            screenResultTxtView.text = ""
            screenExpressionTxtView.append(string)
        }
        else{
            screenExpressionTxtView.append(screenResultTxtView.text)
            screenExpressionTxtView.append(string)
            screenResultTxtView.text = ""
        }

    }


}
