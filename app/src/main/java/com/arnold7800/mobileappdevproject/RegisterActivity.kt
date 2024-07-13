package com.arnold7800.mobileappdevproject

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.arnold7800.mobileappdevproject.databinding.ActivityRegisterBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth

class Register : AppCompatActivity() {

    lateinit var binding : ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        //initialize Firebase Auth
        auth = Firebase.auth

        binding.registerButton.setOnClickListener(){
            createUser()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun createUser() {
        val email = binding.createEmailTextView.text.toString()
        val password = binding.createPasswordTextView.text.toString()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if(task.isSuccessful) {
                    //Sign in is successful, update UI with signed in user's information
                    Log.d("TAGY", "createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    //display a message to the user in case of failure
                    Log.w("TAGY", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication Failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    private fun updateUI(user: FirebaseUser?) {
        TODO("Not yet implemented")
    }

    //checking if the user is signed in
    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null) {
           reload()
        }
    }

    private fun reload() {
        TODO("Not yet implemented")
    }
}