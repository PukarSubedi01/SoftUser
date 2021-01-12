package com.pukar.softuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.pukar.softuser.adapters.ViewPageAdapter
import com.pukar.softuser.fragments.AboutUsFragment
import com.pukar.softuser.fragments.AddStudentFragment
import com.pukar.softuser.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var lstTitle : ArrayList<String>
    private lateinit var lstFragments: ArrayList<Fragment>
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout : TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        addToList()
        val adapter = ViewPageAdapter(lstFragments,supportFragmentManager,lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout,viewPager){tab, position ->
            tab.text = lstTitle[position]
        }.attach()
    }
    private fun addToList(){
        lstTitle = ArrayList()
        lstFragments = ArrayList<Fragment>()
        lstTitle.add("Home")
        lstTitle.add("Add Students")
        lstTitle.add("About Us")
        lstFragments.add(HomeFragment())
        lstFragments.add(AddStudentFragment())
        lstFragments.add(AboutUsFragment())
    }
}