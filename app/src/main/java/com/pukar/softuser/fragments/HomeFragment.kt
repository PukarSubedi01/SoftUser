package com.pukar.softuser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pukar.softuser.R
import com.pukar.softuser.`object`.student
import com.pukar.softuser.adapters.StudentAdapter
import com.pukar.softuser.model.Students

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class HomeFragment : Fragment() {
    private lateinit var rvDisplayStudents : RecyclerView

    private var param1 : String? =null
    private var param2 : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }
    companion object{
        fun newInstance(param1: String, param2: String) =
                HomeFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvDisplayStudents = view.findViewById(R.id.rvDisplayStudents)
        rvDisplayStudents.adapter?.notifyDataSetChanged()
        val adapter = StudentAdapter(student.lstStudent, context!!)
        rvDisplayStudents.adapter=adapter
        rvDisplayStudents.layoutManager = LinearLayoutManager(context)

    }


}