// Tutorial from https://www.youtube.com/watch?v=QQa6Pt9AtRE&list=PLY_ZW4F4wPwTApfo0tVFtj97cZxFNFlEs&index=2&t=33s
package com.example.myfirstcalculatorapp

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_slider.*

class SliderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)

//      es lo mismo q   val initialTextViewTranslation = findViewById<TextView>(R.id.progressTextView)
        val initialTextViewTranslationY = progressCTextView.translationY

        progressSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            @SuppressLint("ResourceAsColor")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progressCTextView.text = progress.toString()+ " C"
                val progressinFar = (progress.toInt()*9/5)+32
                progressFarTextView.text = (progressinFar).toString()+" F"
                if(progressinFar >= 73){
                    progressFarTextView.setTextColor(Color.RED)
                }
                else if (progressinFar > 55 && progressinFar < 73){
                    progressFarTextView.setTextColor(Color.parseColor("#FF7B00"))
                }
                else progressFarTextView.setTextColor(ContextCompat.getColor(this@SliderActivity, R.color.lightBlue))

                // an upward movement with -1   ||    animstep | distance that the progressC will be translated.
                val translationDistance = (initialTextViewTranslationY + progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                progressCTextView.animate().translationY(translationDistance)

                if(!fromUser)
                    progressCTextView.animate().setDuration(500).rotationBy(360f).translationY(initialTextViewTranslationY)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        }
        )

        resetButton.setOnClickListener{  v ->
            progressSeekBar.progress = 0

        }
    }
}
