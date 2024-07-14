package com.arnold7800.mobileappdevproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.arnold7800.mobileappdevproject.databinding.FragmentBusinessNameRegBinding

class BusinessNameRegFragment : Fragment() {
    private lateinit var binding: FragmentBusinessNameRegBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_business_name_reg, container, false)

        //the click event on button
        binding.businessNameRegbutton.setOnClickListener{
            it.findNavController().navigate(R.id.action_businessNameRegFragment_to_businessNameRegPaymentFragment)
        }
        return binding.root
    }
}