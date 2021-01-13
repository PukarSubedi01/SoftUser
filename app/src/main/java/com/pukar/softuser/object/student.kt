package com.pukar.softuser.`object`

import com.pukar.softuser.model.Students

object student {
    var lstStudent = arrayListOf<Students>()
    fun addStudent(){
        lstStudent.add(Students("Pukar Subedi","21","Sanepa","Male"))
        lstStudent.add(Students("Nikita","20","Satdobato","Female"))
        lstStudent.add(Students("Dipesh Lama","21","Bhaktapur","Male"))
    }
}