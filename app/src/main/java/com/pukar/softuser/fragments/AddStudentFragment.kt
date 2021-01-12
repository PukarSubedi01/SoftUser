package com.pukar.softuser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.pukar.softuser.R
import com.pukar.softuser.model.Students


class AddStudentFragment : Fragment() {
private lateinit var etName: EditText
private lateinit var etAge: EditText
private lateinit var etAddress: EditText
private lateinit var rbMale: RadioButton
private lateinit var rbFemale: RadioButton
private lateinit var rbOthers: RadioButton
private lateinit var btnSave: Button
private lateinit var radioGroup: RadioGroup
val lstStudents : ArrayList<Students> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)
        var gender:String = ""
        etName = view.findViewById(R.id.etName)
        etAge = view.findViewById(R.id.etAge)
        etAddress = view.findViewById(R.id.etAddress)
        rbMale = view.findViewById(R.id.rbMale)
        rbFemale = view.findViewById(R.id.rbFemale)
        rbOthers = view.findViewById(R.id.rbOthers)
        btnSave = view.findViewById(R.id.btnSave)
        radioGroup = view.findViewById(R.id.radioGroup)
        when{
            rbMale.isChecked-> gender = rbMale.text.toString()
            rbFemale.isChecked-> gender = rbFemale.text.toString()
            rbOthers.isChecked-> gender = rbOthers.text.toString()
        }
        btnSave.setOnClickListener{
            if (isInputFieldValid()){
                lstStudents.add(Students(etName.toString(),etAge.toString().toInt(),etAddress.toString(),gender))
                Toast.makeText(context, "Student Added", Toast.LENGTH_SHORT).show()
            }

        }
        return view
    }
    private fun isInputFieldValid():Boolean{
        when {
            etName.text.isEmpty() -> {
                etName.error = "Field must not be empty"
                return false
            }
            etAge.text.isEmpty() -> {
                etAge.error = "Field must not be empty"
                return false
            }
            etAddress.text.isEmpty() -> {
                etAddress.error = "Field must not be empty"
                return false
            }
            radioGroup.checkedRadioButtonId == -1 -> {
                Toast.makeText(context, "Please select a gender", Toast.LENGTH_LONG).show()
                return false
            }

        }
        return true
    }

}