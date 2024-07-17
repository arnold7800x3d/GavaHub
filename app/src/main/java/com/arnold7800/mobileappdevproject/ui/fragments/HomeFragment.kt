package com.arnold7800.mobileappdevproject.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.arnold7800.mobileappdevproject.R
import com.arnold7800.mobileappdevproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.passportButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_passportFragment)
        }

        binding.idButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_nationalIDFragment)
        }

        binding.kraButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_kraFragment)
        }

        binding.dLButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_drivingLicenseFragment)
        }

        binding.nameRegButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_businessNameRegFragment)
        }

        binding.businessRegButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_businessRegFragment)
        }

        binding.websitebutton3.setOnClickListener(){
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://accounts.ecitizen.go.ke/en"))
            startActivity(intent)
        }

        return binding.root
    }
}