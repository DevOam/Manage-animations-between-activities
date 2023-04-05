package com.example.animationpersonalise

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonFadeIn = findViewById<Button>(R.id.button_fade_in)
        val buttonFadeOut = findViewById<Button>(R.id.button_fade_out)
        val buttonSlideInLeft = findViewById<Button>(R.id.button_slide_in_left)
        val buttonSlideOutRight = findViewById<Button>(R.id.button_slide_out_right)
        val buttonZoomIn = findViewById<Button>(R.id.button_zoom_in)
        val buttonZoomOut = findViewById<Button>(R.id.button_zoom_out)
        val buttonRotate = findViewById<Button>(R.id.button_rotate)
        val buttonCustom = findViewById<Button>(R.id.Custom_transitions)

        buttonFadeIn.setOnClickListener {
            startAnimation(R.anim.fade_in)
        }

        buttonFadeOut.setOnClickListener {
            startAnimation(R.anim.fade_out)
        }

        buttonSlideInLeft.setOnClickListener {
            startAnimation(R.anim.slide_in_left)
        }

        buttonSlideOutRight.setOnClickListener {
            startAnimation(R.anim.slide_out_right)
        }

        buttonZoomIn.setOnClickListener {
            startAnimation(R.anim.zoom_in)
        }

        buttonZoomOut.setOnClickListener {
            startAnimation(R.anim.zoom_out)
        }

        buttonRotate.setOnClickListener {
            startAnimation(R.anim.rotate)
        }

        buttonCustom.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.custom_animation)
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}
                override fun onAnimationEnd(animation: Animation?) {
                    startActivity(Intent(this@MainActivity, SecondActivity::class.java))
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                }

                override fun onAnimationRepeat(animation: Animation?) {}
            })
            findViewById<View>(android.R.id.content).startAnimation(animation)
        }
    }
    private fun startAnimation(animationId: Int) {
        val animation = AnimationUtils.loadAnimation(this, animationId)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                startActivity(Intent(this@MainActivity, SecondActivity::class.java))
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })
        findViewById<View>(android.R.id.content).startAnimation(animation)
    }
}

