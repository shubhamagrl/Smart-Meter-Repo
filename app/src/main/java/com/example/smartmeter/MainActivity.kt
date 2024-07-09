package com.example.smartmeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.smartmeter.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        var u1 = User(44,"Shubham","27")
        binding.user = u1

        binding.apply {
            idbutton.setOnClickListener() {
                Toast.makeText(it.context, "You clicked", Toast.LENGTH_SHORT).show()

            }
        }
    }
}