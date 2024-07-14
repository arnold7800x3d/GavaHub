package com.arnold7800.mobileappdevproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.arnold7800.mobileappdevproject.databinding.FragmentBusinessNameRegPaymentBinding

class BusinessNameRegPaymentFragment : Fragment() {
    private lateinit var binding: FragmentBusinessNameRegPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_business_name_reg_payment, container, false)
        return binding.root
    }
}