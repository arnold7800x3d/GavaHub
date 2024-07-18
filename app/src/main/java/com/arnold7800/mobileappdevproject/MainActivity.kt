package com.arnold7800.mobileappdevproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.arnold7800.mobileappdevproject.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    //Firebase Auth
    private lateinit var auth: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Load the saved language preference
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        loadLocale()

        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.createAccountButton.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        binding.loginButton.setOnClickListener {
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
                        "Authentication Failed, check your internet connection",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }

    private fun goToHomeActivity() {
        val intent = Intent(this, NewHomeActivity::class.java)
        startActivity(intent)
    }

    private fun loadLocale() {
        val languageCode = sharedPreferences.getString("selected_language", "en")
        if (languageCode != null) {
            setLocale(languageCode)
        }
    }

    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}
