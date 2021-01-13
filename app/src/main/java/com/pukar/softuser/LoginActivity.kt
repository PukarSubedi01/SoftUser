package com.pukar.softuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var etUserName : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnLogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etUserName = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnLogin .setOnClickListener{


            if(isInputFieldValid()){
                if (loginValidation()){
                    val intent = Intent(this, BottomNavActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else
                    Toast.makeText(this, "Incorrect Email/password", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun isInputFieldValid():Boolean{
        when {
            etUserName.text.isEmpty() -> {
                etUserName.error = "Field must not be empty"
                return false
            }
            etPassword.text.isEmpty() -> {
                etPassword.error = "Field must not be empty"
                return false
            }
        }
        return true
    }
    private fun loginValidation():Boolean{
        if (etUserName.text.toString()=="softwarica" && etPassword.text.toString() == "coventry"){
            return true
        }
        return false
    }
}