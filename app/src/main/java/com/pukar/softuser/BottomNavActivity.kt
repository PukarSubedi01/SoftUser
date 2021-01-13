package com.pukar.softuser

import android.os.Bundle
import android.widget.LinearLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.pukar.softuser.`object`.student
import com.pukar.softuser.fragments.AboutUsFragment
import com.pukar.softuser.fragments.AddStudentFragment
import com.pukar.softuser.fragments.HomeFragment

class BottomNavActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var linearFragment : LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)
        bottomNavigationView=findViewById(R.id.bottomNavigationView)
        linearFragment=findViewById(R.id.linearFragment)
        val homeFragment= HomeFragment()
        val addStudentFragment= AddStudentFragment()
        val aboutUsFragment= AboutUsFragment()
        student.addStudent()
        setCurrentFragment(homeFragment)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navHome->{
                    setCurrentFragment(homeFragment)
                    true
                }
                R.id.navAddStudents->{
                    setCurrentFragment(addStudentFragment)
                    true
                }
                R.id.navAbout->{
                    setCurrentFragment(aboutUsFragment)
                    true
                }
                else -> false
            }
        }

    }
    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.linearFragment, fragment)
            commit()
        }
    }
}