package com.pukar.softuser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.pukar.softuser.R
import com.pukar.softuser.`object`.student
import com.pukar.softuser.adapters.StudentAdapter
import com.pukar.softuser.model.Students

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AddStudentFragment : Fragment() {
private lateinit var etName: EditText
private lateinit var etAge: EditText
private lateinit var etAddress: EditText
private lateinit var rbMale: RadioButton
private lateinit var rbFemale: RadioButton
private lateinit var rbOthers: RadioButton
private lateinit var btnSave: Button
private lateinit var radioGroup: RadioGroup
    private var param1: String? = null
    private var param2: String? = null

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
        val view =  inflater.inflate(R.layout.fragment_add, container, false)
        return view
    }
    companion object{
        fun newInstance(param1: String, param2: String) =
                AddStudentFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var gender:String = ""
        etName = view.findViewById(R.id.etName)
        etAge = view.findViewById(R.id.etAge)
        etAddress = view.findViewById(R.id.etAddress)
        rbMale = view.findViewById(R.id.rbMale)
        rbFemale = view.findViewById(R.id.rbFemale)
        rbOthers = view.findViewById(R.id.rbOthers)
        btnSave = view.findViewById(R.id.btnSave)
        radioGroup = view.findViewById(R.id.radioGroup)

        btnSave.setOnClickListener{

            if (isInputFieldValid()){
                when{
                    rbMale.isChecked-> gender = rbMale.text.toString()
                    rbFemale.isChecked-> gender = rbFemale.text.toString()
                    rbOthers.isChecked-> gender = rbOthers.text.toString()
                }
                student.lstStudent.add(Students(etName.text.toString(),etAge.text.toString(),etAddress.text.toString(),gender))
                clearFields()

            }
            else{
                return@setOnClickListener
            }

        }
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
    private fun clearFields(){
        etName.setText("")
        etAddress.setText("")
        etAge.setText("")
        rbMale.isChecked = false
        rbFemale.isChecked = false
        rbOthers.isChecked = false
    }

}