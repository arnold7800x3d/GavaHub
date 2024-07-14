package com.arnold7800.mobileappdevproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.arnold7800.mobileappdevproject.databinding.FragmentBusinessRegBinding

class BusinessRegFragment : Fragment() {
    private lateinit var binding: FragmentBusinessRegBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_business_reg, container, false)

        //on click event
        binding.busRNextbutton.setOnClickListener{
            it.findNavController().navigate(R.id.action_businessRegFragment_to_businessRegFileUploadFragment)
        }
        return binding.root
    }
}