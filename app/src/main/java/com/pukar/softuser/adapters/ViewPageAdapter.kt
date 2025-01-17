package com.pukar.softuser.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPageAdapter(
    val lstFragments: ArrayList<Fragment>,
    fragmentManager : FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager,lifecycle){
    override fun getItemCount(): Int {
       return lstFragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return lstFragments[position]
    }

}