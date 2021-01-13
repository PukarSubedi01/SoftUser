package com.pukar.softuser.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.pukar.softuser.R
import com.pukar.softuser.model.Students

class StudentAdapter(val lstStudent: ArrayList<Students>, val context:Context):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(view:View):RecyclerView.ViewHolder(view){
        val tvName : TextView= view.findViewById(R.id.tvName)
        val tvAge : TextView= view.findViewById(R.id.tvAge)
        val tvAddress : TextView= view.findViewById(R.id.tvAddress)
        val tvGender : TextView= view.findViewById(R.id.tvGender)
        val imgProfilePic: ImageView = view.findViewById(R.id.profilePic)
        val imgDelete : ImageView = view.findViewById(R.id.imgDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_layout,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
       val student = lstStudent[position]
       holder.tvName.text = student.fullName
       holder.tvAddress.text = student.address
       holder.tvAge.text = student.age.toString()
       holder.tvGender.text = student.gender
        if (student.gender == "Male"){
            holder.imgProfilePic.setImageResource(R.drawable.male_pp)
        }
        else if (student.gender == "Female"){
            holder.imgProfilePic.setImageResource(R.drawable.female_pp)
        }
        else
            holder.imgProfilePic.setImageResource(R.drawable.noimage)
        holder.imgProfilePic.setOnClickListener{
            Toast.makeText(context, "Hello this is ${student.fullName}", Toast.LENGTH_SHORT).show()
        }
        holder.imgDelete.setOnClickListener{
            lstStudent.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
       return lstStudent.size
    }
}