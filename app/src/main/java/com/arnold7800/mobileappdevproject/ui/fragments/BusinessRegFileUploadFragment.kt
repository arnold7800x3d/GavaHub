package com.arnold7800.mobileappdevproject.ui.fragments

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.arnold7800.mobileappdevproject.R
import com.arnold7800.mobileappdevproject.databinding.FragmentBusinessRegFileUploadBinding


class BusinessRegFileUploadFragment : Fragment() {
    private lateinit var binding: FragmentBusinessRegFileUploadBinding

    private var fileUri1: Uri? = null

    private val filePicker1 = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            fileUri1 = it
            binding.fileName1.text = it.lastPathSegment ?: "No file selected"
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_business_reg_file_upload, container, false)

        binding.fileUploadButton1.setOnClickListener {
            filePicker1.launch("application/pdf")
        }

        //on click event
        binding.busRPaymentbutton.setOnClickListener{
            if (fileUri1 != null) {
                it.findNavController()
                    .navigate(R.id.action_businessRegFileUploadFragment_to_businessRegPaymentFragment)
            } else {
                Toast.makeText(requireContext(), "Please select all required files!!", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }
}