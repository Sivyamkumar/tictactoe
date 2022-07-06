package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image :ImageView = findViewById(R.id.tictactoeimage)
        val text : TextView = findViewById(R.id.titactoetext)
        val start : Button = findViewById(R.id.startbutton)

        start.visibility = View.GONE

        image.translationY = -1000f
        text.translationX = -1000f

        image.animate().translationY(0f).duration=3000
        text.animate().translationX(0f).duration=2800

        start.visibility = View.VISIBLE

        start.translationX = 5000f

        start.animate().translationX(0f).duration=4000

        start.setOnClickListener {
            val intent = Intent(this,gameactivity::class.java)
            startActivity(intent)
        }

    }
}