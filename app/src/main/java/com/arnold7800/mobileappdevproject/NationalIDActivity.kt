package com.arnold7800.mobileappdevproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.arnold7800.mobileappdevproject.databinding.ActivityHomeBinding
import com.arnold7800.mobileappdevproject.databinding.ActivityNationalIdactivityBinding

class NationalIDActivity : AppCompatActivity() {

    lateinit var binding: ActivityNationalIdactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityNationalIdactivityBinding.inflate(layoutInflater) // Initialize binding here
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}