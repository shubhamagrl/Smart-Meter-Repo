package com.example.smartmeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.smartmeter.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var myAdapter: MyPagerAdapter
    lateinit var tablayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()
    }
    private fun setup(){

        viewPager = findViewById(R.id.idviewPager)
        tablayout = findViewById(R.id.idtablayout)

        val myAdapter = MyPagerAdapter(supportFragmentManager)
        myAdapter.addFragments(fragment_one(),"Home")
        myAdapter.addFragments(fragment_two(),"Bill")
        myAdapter.addFragments(fragment_three(),"Program")
        viewPager.adapter = myAdapter
        tablayout.setupWithViewPager(viewPager)

        tablayout.getTabAt(0)!!.setIcon(R.drawable.home_icon)
        tablayout.getTabAt(1)!!.setIcon(R.drawable.bill_icon)
        tablayout.getTabAt(2)!!.setIcon(R.drawable.programs_icon)
    }

}