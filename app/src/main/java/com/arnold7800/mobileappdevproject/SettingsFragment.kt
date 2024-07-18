package com.arnold7800.mobileappdevproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Switch
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.Locale

class SettingsFragment : Fragment() {

    private lateinit var spinner: Spinner
    private lateinit var switchButton: Switch

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        // Initialize views
        spinner = view.findViewById(R.id.language_spinner)
        switchButton = view.findViewById(R.id.notification_switch)

        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.languages,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            spinner.adapter = adapter
        }

        // Set spinner item selected listener
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedLanguage = parent.getItemAtPosition(position).toString()
                when (selectedLanguage) {
                    "English" -> {
                        updateConfiguration(Locale.ENGLISH)
                    }
                    "Swahili" -> {
                        updateConfiguration(Locale("sw", "KE"))
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle nothing selected (if needed)
            }
        }

        // Set switch checked change listener
        switchButton.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) {
                "Notifications Enabled"
            } else {
                "Enable Notifications"
            }
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }

        view.findViewById<View>(R.id.save_button).setOnClickListener {
            Toast.makeText(requireContext(), "Settings Saved", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    private fun updateConfiguration(locale: Locale) {
        val config = resources.configuration
        config.setLocale(locale) // use setLocale instead of locale for newer Android versions
        resources.updateConfiguration(config, resources.displayMetrics)
        requireActivity().recreate() // Restart the activity to apply the changes
    }
}
