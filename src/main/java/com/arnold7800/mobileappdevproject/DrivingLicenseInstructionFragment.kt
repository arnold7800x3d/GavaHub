package com.arnold7800.mobileappdevproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.arnold7800.mobileappdevproject.databinding.FragmentDrivingLicenseInstructionBinding

class DrivingLicenseInstructionFragment : Fragment() {
    private lateinit var binding: FragmentDrivingLicenseInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_driving_license_instruction, container, false)

        //on click event
        binding.dLPaymentbutton3.setOnClickListener{
            it.findNavController().navigate(R.id.action_drivingLicenseInstructionFragment_to_drivingLicensePaymentFragment)
        }
        return binding.root
    }
}