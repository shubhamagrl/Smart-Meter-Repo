package com.example.smartmeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var myButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myButton = findViewById(R.id.button)
        myButton.setOnClickListener{
            Toast.makeText(this, "You clicked the button", Toast.LENGTH_LONG).show()
        }
    }
}