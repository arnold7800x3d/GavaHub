package com.arnold7800.mobileappdevproject

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.arnold7800.mobileappdevproject.databinding.FragmentPassportFileUploadBinding

class PassportFileUploadFragment : Fragment() {
    private lateinit var binding: FragmentPassportFileUploadBinding

    private var fileUri1: Uri? = null
    private var fileUri2: Uri? = null
    private var fileUri3: Uri? = null
    private var fileUri4: Uri? = null

    private val filePicker1 = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            fileUri1 = it
            binding.fileName1.text = it.lastPathSegment ?: "No file selected"
        }
    }

    private val filePicker2 = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            fileUri2 = it
            binding.fileName2.text = it.lastPathSegment ?: "No file selected"
        }
    }

    private val filePicker3 = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            fileUri3 = it
            binding.fileName3.text = it.lastPathSegment ?: "No file selected"
        }
    }

    private val filePicker4 = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            fileUri4 = it
            binding.fileName4.text = it.lastPathSegment ?: "No file selected"
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_passport_file_upload, container, false)

        binding.fileUploadButton1.setOnClickListener {
            filePicker1.launch("application/pdf")
        }

        binding.fileUploadButton2.setOnClickListener {
            filePicker2.launch("application/pdf")
        }

        binding.fileUploadButton3.setOnClickListener {
            filePicker3.launch("application/pdf")
        }

        binding.fileUploadButton4.setOnClickListener {
            filePicker4.launch("application/pdf")
        }

        binding.passportFileNextbutton3.setOnClickListener {
            // Check if all files are selected before navigating
            if (fileUri1 != null && fileUri2 != null && fileUri3 != null && fileUri4 != null) {
                it.findNavController()
                    .navigate(R.id.action_passportFileUploadFragment_to_passportPaymentFragment)
            } else {
                Toast.makeText(requireContext(), "Please select all required files!!", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }
}
