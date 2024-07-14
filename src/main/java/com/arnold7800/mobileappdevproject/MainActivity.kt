package com.arnold7800.mobileappdevproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.arnold7800.mobileappdevproject.databinding.ActivityMainBinding
import com.arnold7800.mobileappdevproject.databinding.ActivityRegisterBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    //Firebase Auth
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.createAccountButton.setOnClickListener() {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        binding.loginButton.setOnClickListener() {
            loginWithEmailPassword(
                binding.idLoginTextView.text.toString().trim(),
                binding.passwordLoginTextView.text.toString().trim()
            )
        }

        //Auth ref
        auth = Firebase.auth

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loginWithEmailPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //Sign in Success
                    val user = auth.currentUser
                    goToHomeActivity()

                } else {
                    Toast.makeText(
                        this,
                        "Authentication Failed",
                        Toast.LENGTH_LONG
                    ).show()

                }

            }
    }

        override fun onStart() {
            super.onStart()
            val currentUser = auth.currentUser

            if (currentUser != null) {
                goToHomeActivity()
            }
        }

        private fun goToHomeActivity() {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
}