package com.arnold7800.mobileappdevproject.ui.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.arnold7800.mobileappdevproject.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private var profileImageUri: Uri? = null

    private val imagePickerLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        if (uri != null) {
            profileImageUri = uri
            binding.profileImageView.setImageURI(uri)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        // Load saved profile info
        loadProfile()

        // Set up the image picker
        binding.setProfileImageButton.setOnClickListener {
            imagePickerLauncher.launch("image/*")
        }

        // Set up the save button
        binding.saveProfileButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            if (name.isNotEmpty() && profileImageUri != null) {
                // Save the profile info to SharedPreferences
                saveProfile(name, profileImageUri.toString())
                Toast.makeText(requireContext(), "Profile updated!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun saveProfile(name: String, imageUri: String) {
        val sharedPreferences = requireActivity().getSharedPreferences("UserProfile", AppCompatActivity.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("userName", name)
        editor.putString("profileImageUri", imageUri)
        editor.apply()
    }

    private fun loadProfile() {
        val sharedPreferences = requireActivity().getSharedPreferences("UserProfile", AppCompatActivity.MODE_PRIVATE)
        val savedName = sharedPreferences.getString("userName", "")
        val savedImageUri = sharedPreferences.getString("profileImageUri", null)

        binding.nameEditText.setText(savedName)

        if (savedImageUri != null) {
            profileImageUri = Uri.parse(savedImageUri)
            binding.profileImageView.setImageURI(profileImageUri)
        }
    }
}
