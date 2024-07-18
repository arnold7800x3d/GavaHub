package com.arnold7800.mobileappdevproject

import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.arnold7800.mobileappdevproject.databinding.FragmentProfileBinding
import android.Manifest
import android.content.ContentResolver
import android.graphics.Bitmap
import android.graphics.BitmapFactory

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private var profileImageUri: Uri? = null
    private val REQUEST_CODE_READ_EXTERNAL_STORAGE = 100

    private val imagePickerLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        if (uri != null) {
            profileImageUri = uri
            // Use MediaStore to get a bitmap from the URI
            val bitmap = getBitmapFromUri(requireContext().contentResolver, uri)
            binding.profileImageView.setImageBitmap(bitmap)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        loadProfile()

        binding.setProfileImageButton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                imagePickerLauncher.launch("image/*")
            } else {
                ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_CODE_READ_EXTERNAL_STORAGE)
            }
        }



        binding.saveProfileButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            if (name.isNotEmpty() && profileImageUri != null) {

                saveProfile(name, profileImageUri.toString())
                Toast.makeText(requireContext(), "Profile updated!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == REQUEST_CODE_READ_EXTERNAL_STORAGE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                imagePickerLauncher.launch("image/*")
            } else {
                Toast.makeText(requireContext(), "Permission required to access images.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getBitmapFromUri(contentResolver: ContentResolver, uri: Uri): Bitmap? {
        return try {
            contentResolver.openInputStream(uri)?.use { inputStream ->
                BitmapFactory.decodeStream(inputStream)
            }
        } catch (e: Exception) {
            // Handle exceptions (e.g., file not found)
            null
        }
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
