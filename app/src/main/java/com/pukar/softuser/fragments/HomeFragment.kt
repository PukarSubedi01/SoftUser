package com.pukar.softuser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pukar.softuser.R
import com.pukar.softuser.adapters.StudentAdapter
import com.pukar.softuser.model.Students

class HomeFragment : Fragment() {
    private lateinit var rvDisplayStudents : RecyclerView
    private var lstStudents = ArrayList<Students>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        rvDisplayStudents = view.findViewById(R.id.rvDisplayStudents)
        students()
        val adapter = StudentAdapter(lstStudents, context!!)
        rvDisplayStudents.layoutManager = LinearLayoutManager(context)
        rvDisplayStudents.adapter=adapter
        return view
    }
    private fun students(){
        lstStudents.add(Students("Pukar Subedi",21,"Sanepa","Male"))
        lstStudents.add(Students("Ruby Bhandari",20,"Satdobato","Female"))
        lstStudents.add(Students("Dipesh Lama",21,"Bhaktapur","Male"))
        lstStudents.add(Students("Dipesh Lama",21,"Bhaktapur","Male"))
        lstStudents.add(Students("Dipesh Lama",21,"Bhaktapur","Male"))
        lstStudents.add(Students("Dipesh Lama",21,"Bhaktapur","Male"))
        lstStudents.add(Students("Dipesh Lama",21,"Bhaktapur","Male"))
        lstStudents.add(Students("Dipesh Lama",21,"Bhaktapur","Male"))
    }
}