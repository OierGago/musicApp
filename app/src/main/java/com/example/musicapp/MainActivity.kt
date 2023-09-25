package com.example.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    var presionado = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val play : ImageView = findViewById<ImageView>(R.id.play)
//        val pause : ImageView = findViewById<ImageView>(R.id.imageViewPause)

        play.setOnClickListener {
            if (presionado == false) {
                play.setImageDrawable(getDrawable(R.drawable.intro))
                presionado = true

            } else if (presionado == true){
                play.setImageDrawable(getDrawable(R.drawable.pause))
                presionado = false

            }

        }

    }

    override fun onResume() {
        super.onResume()
        Log.d("Debug", "onResume")
        val play : ImageView = findViewById<ImageView>(R.id.play)

        if (presionado == false) {
            play.setImageDrawable(getDrawable(R.drawable.intro))
            presionado = true

        } else if (presionado == true){
            play.setImageDrawable(getDrawable(R.drawable.pause))
            presionado = false

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {


        Log.d("Debug","onSaveInstanceState")
        // Save the user's current game state.
        outState?.run {
            putBoolean("result", presionado)

        }
        // Always call the superclass so it can save the view hierarchy.
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Always call the superclass so it can restore the view hierarchy.
        super.onRestoreInstanceState(savedInstanceState)


        // Restore state members from saved instance.
        savedInstanceState?.run {
            presionado = savedInstanceState.getBoolean("result")
            val play: ImageView = findViewById<ImageView>(R.id.play)

            if (presionado == false) {
                play.setImageDrawable(getDrawable(R.drawable.intro))
                presionado = true

            } else if (presionado == true) {
                play.setImageDrawable(getDrawable(R.drawable.pause))
                presionado = false

            }
        }
    }
}