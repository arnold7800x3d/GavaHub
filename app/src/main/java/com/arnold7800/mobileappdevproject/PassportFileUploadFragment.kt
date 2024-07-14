package com.arnold7800.mobileappdevproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.arnold7800.mobileappdevproject.databinding.FragmentPassportBinding
import com.arnold7800.mobileappdevproject.databinding.FragmentPassportFileUploadBinding

class PassportFileUploadFragment : Fragment() {
    private lateinit var binding: FragmentPassportFileUploadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_passport_file_upload, container, false)


        binding.passportFileNextbutton3.setOnClickListener{
            it.findNavController().navigate(R.id.action_passportFileUploadFragment_to_passportPaymentFragment)
        }
        return binding.root
    }
}