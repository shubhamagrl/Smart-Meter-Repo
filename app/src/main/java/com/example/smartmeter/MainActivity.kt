package com.example.smartmeter

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
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

        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val tabIcon = tab.customView?.findViewById<ImageView>(R.id.tab_icon)
                val tabTitle = tab.customView?.findViewById<TextView>(R.id.tab_title)

                // Change color when tab is selected
                tabIcon?.setColorFilter(ContextCompat.getColor(this@MainActivity, R.color.selectedColor), PorterDuff.Mode.SRC_IN)
                tabTitle?.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.selectedColor))
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val tabIcon = tab.customView?.findViewById<ImageView>(R.id.tab_icon)
                val tabTitle = tab.customView?.findViewById<TextView>(R.id.tab_title)

                // Revert color when tab is unselected
                tabIcon?.setColorFilter(ContextCompat.getColor(this@MainActivity, R.color.unselectedColor), PorterDuff.Mode.SRC_IN)
                tabTitle?.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.unselectedColor))
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getTabView(position: Int): View {
        val view = LayoutInflater.from(this).inflate(R.layout.custom_tab, null)
        val tabIcon: ImageView = view.findViewById(R.id.tab_icon)
        val tabTitle: TextView = view.findViewById(R.id.tab_title)

        when (position) {
            0 -> {
                tabIcon.setImageResource(R.drawable.home_icon)
                tabTitle.text = "Home"
            }

            1 -> {
                tabIcon.setImageResource(R.drawable.bill_icon)
                tabTitle.text = "Bill"
            }

            2 -> {
                tabIcon.setImageResource(R.drawable.programs_icon)
                tabTitle.text = "Events"
            }

            3 -> {
                tabIcon.setImageResource(R.drawable.help_icon)
                tabTitle.text = "Help"
            }
        }
        return view
    }

    private fun setup() {

        viewPager = findViewById(R.id.idviewPager)
        tablayout = findViewById(R.id.idtablayout)

        val myAdapter = MyPagerAdapter(supportFragmentManager)
        myAdapter.addFragments(fragment_one(), "Home")
        myAdapter.addFragments(fragment_two(), "Bill")
        myAdapter.addFragments(fragment_three(), "Program")
        myAdapter.addFragments(fragment_four(), "Help")

        viewPager.adapter = myAdapter
        tablayout.setupWithViewPager(viewPager)

        for (i in 0 until tablayout.tabCount) {
            val tab = tablayout.getTabAt(i)
            tab?.customView = getTabView(i)
        }
    }

}