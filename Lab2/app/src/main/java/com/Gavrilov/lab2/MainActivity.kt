package com.Gavrilov.lab2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import android.widget.TextView


class MainActivity : ComponentActivity() {
    private var clickValue = 1
    private var clickCount = 0
    private var currentImage = R.drawable.image1
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val button = findViewById<Button>(R.id.button)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        button.setOnClickListener {
            clickCount += clickValue

            when {
                clickCount >= 1200 -> clickValue *= 4
                clickCount >= 40 -> clickValue *= 3
                clickCount >= 12 -> clickValue *= 2
            }
            scoreTextView.text = "Очки: ${clickCount}"
            currentImage = if (currentImage == R.drawable.image1) R.drawable.image2 else R.drawable.image1
            imageView.setImageResource(currentImage)

        }
    }
}
