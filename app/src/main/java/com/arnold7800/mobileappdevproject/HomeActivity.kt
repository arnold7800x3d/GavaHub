package com.arnold7800.mobileappdevproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.arnold7800.mobileappdevproject.databinding.ActivityHomeBinding
import com.arnold7800.mobileappdevproject.databinding.FragmentKraPaymentBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityHomeBinding.inflate(layoutInflater) // Initialize binding here
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProfileFragment()) // Default fragment
                .commit()
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ProfileFragment())
                        .commit()
                    true
                }
                R.id.settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, SettingsFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }


        //passport button
        binding.passportButton.setOnClickListener(){
            var intent: Intent = Intent(this, PassportActivity::class.java)
            startActivity(intent)
        }

        //national ID button
        binding.idButton.setOnClickListener(){
            var intent: Intent = Intent(this, NationalIDActivity::class.java)
            startActivity(intent)
        }

        //kra button
        binding.kraButton.setOnClickListener(){
            var intent: Intent = Intent(this, KraActivity::class.java)
            startActivity(intent)
        }

        //driver's License button
        binding.dLButton.setOnClickListener(){
            var intent: Intent = Intent(this, DrivingLicenseActivity::class.java)
            startActivity(intent)
        }

        //business name reg button
        binding.nameRegButton.setOnClickListener(){
            var intent: Intent = Intent(this, BusinessNameRegActivity::class.java)
            startActivity(intent)
        }

        //business rev button
        binding.businessRegButton.setOnClickListener(){
            var intent: Intent = Intent(this, BusinessRegActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment) // Ensure you have a FrameLayout with this id in your layout
        transaction.addToBackStack(null) // Add this transaction to the back stack
        transaction.commit()
    }
}