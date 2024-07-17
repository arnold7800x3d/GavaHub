package com.arnold7800.mobileappdevproject

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.arnold7800.mobileappdevproject.databinding.ActivityNewHomeBinding

class NewHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNewHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "GavaHub"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

       /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.gavahub_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            R.id.profile -> {
                //ProfileFragment
                findNavController(R.id.nav_host_fragment).navigate(R.id.action_homeFragment_to_profileFragment)
                true
            }
           R.id.settings -> {
                //SettingsFragment
                findNavController(R.id.nav_host_fragment).navigate(R.id.action_homeFragment_to_settingsFragment)
                true
            }
            R.id.logout -> {
                findNavController(R.id.nav_host_fragment).navigate(R.id.action_homeFragment_to_logoutFragment)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}