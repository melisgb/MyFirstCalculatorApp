// Tutorial from https://www.youtube.com/watch?v=QQa6Pt9AtRE&list=PLY_ZW4F4wPwTApfo0tVFtj97cZxFNFlEs&index=2&t=33s
package com.example.myfirstcalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_slider.*

class SliderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)

//      es lo mismo q   val initialTextViewTranslation = findViewById<TextView>(R.id.progressTextView)
        val initialTextViewTranslationY = progressTextView.translationY

        progressSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progressTextView.text = progress.toString()
                // an upward movement with -1   ||    animstep
                val translationDistance = (initialTextViewTranslationY + progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                progressTextView.animate().translationY(translationDistance)

                if(!fromUser)
                    progressTextView.animate().setDuration(500).rotationBy(360f).translationY(initialTextViewTranslationY)
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
