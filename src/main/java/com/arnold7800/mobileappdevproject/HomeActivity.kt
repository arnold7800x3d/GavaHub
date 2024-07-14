package com.arnold7800.mobileappdevproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.arnold7800.mobileappdevproject.databinding.ActivityHomeBinding
import com.arnold7800.mobileappdevproject.databinding.FragmentKraPaymentBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityHomeBinding.inflate(layoutInflater) // Initialize binding here
        setContentView(binding.root)

        //kra button
        binding.kraButton.setOnClickListener(){
            var intent: Intent = Intent(this, KraActivity::class.java)
            startActivity(intent)
        }

        //business name reg button
        binding.businessRegButton.setOnClickListener(){
            var intent: Intent = Intent(this, BusinessNameRegActivity::class.java)
            startActivity(intent)
        }

        //driver's License button
        binding.dLButton.setOnClickListener(){
            var intent: Intent = Intent(this, DrivingLicenseActivity::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}