package com.arnold7800.mobileappdevproject

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Switch
import android.widget.Toast
import androidx.fragment.app.Fragment
//import androidx.preference.PreferenceManager
import java.util.*

class SettingsFragment : Fragment() {

    private lateinit var languageSpinner: Spinner
    private lateinit var notificationSwitch: Switch
    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        languageSpinner = view.findViewById(R.id.language_spinner)
        notificationSwitch = view.findViewById(R.id.notification_switch)
        saveButton = view.findViewById(R.id.save_button)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        loadSettings(sharedPreferences)


        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.languages,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            languageSpinner.adapter = adapter
        }

        saveButton.setOnClickListener {
            saveSettings(sharedPreferences)
        }
    }

    private fun loadSettings(sharedPreferences: SharedPreferences) {

        val language = sharedPreferences.getString("app_language", "English")
        val languagePosition = if (language == "Swahili") 1 else 0
        languageSpinner.setSelection(languagePosition)


        val notificationsEnabled = sharedPreferences.getBoolean("notifications_enabled", false)
        notificationSwitch.isChecked = notificationsEnabled
    }

    private fun saveSettings(sharedPreferences: SharedPreferences) {
        val editor = sharedPreferences.edit()


        val selectedLanguage = if (languageSpinner.selectedItemPosition == 1) "Swahili" else "English"
        editor.putString("app_language", selectedLanguage)


        val notificationsEnabled = notificationSwitch.isChecked
        editor.putBoolean("notifications_enabled", notificationsEnabled)

        editor.apply()


        setLocale(selectedLanguage)

        Toast.makeText(requireContext(), getString(R.string.save_settings), Toast.LENGTH_SHORT).show()
    }

    private fun setLocale(language: String) {
        val locale = if (language == "Swahili") Locale("sw") else Locale("en")
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        requireActivity().resources.updateConfiguration(config, requireActivity().resources.displayMetrics)


        requireActivity().recreate()
    }
}
