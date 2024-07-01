package com.example.smartmeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var myButton : Button
    lateinit var mytext : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myButton = findViewById(R.id.button)
        myButton.setOnClickListener{

            mytext.setText("Hello Shubham")
            Toast.makeText(this, "You clicked the button", Toast.LENGTH_LONG).show()
        }
    }
}