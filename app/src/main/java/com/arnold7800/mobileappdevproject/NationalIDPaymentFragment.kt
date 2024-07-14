package com.arnold7800.mobileappdevproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.arnold7800.mobileappdevproject.databinding.FragmentNationalIDBinding
import com.arnold7800.mobileappdevproject.databinding.FragmentNationalIDPaymentBinding

class NationalIDPaymentFragment : Fragment() {
    private lateinit var binding: FragmentNationalIDPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_national_i_d_payment, container, false)
        return binding.root
    }
}