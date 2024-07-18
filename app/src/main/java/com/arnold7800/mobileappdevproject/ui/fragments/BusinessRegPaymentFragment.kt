package com.arnold7800.mobileappdevproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arnold7800.mobileappdevproject.R
import com.arnold7800.mobileappdevproject.api.NetworkModule
import com.arnold7800.mobileappdevproject.databinding.FragmentBusinessRegPaymentBinding
import kotlinx.coroutines.launch

class BusinessRegPaymentFragment : Fragment() {
    private lateinit var binding: FragmentBusinessRegPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_business_reg_payment, container, false)

        binding.busregbutton2.setOnClickListener { view: View ->
            val amount = 1000
            val phone = binding.busregpaymenteditTextPhone.text.toString()
            val type = "Business Registration"

            lifecycleScope.launch {
                try {
                    val response = NetworkModule.darajaApi.initiatePayment(amount, phone, type)
                    Toast.makeText(context, "Processing payment....", Toast.LENGTH_SHORT).show()

                    findNavController().navigate(R.id.action_businessRegPaymentFragment_to_homeFragment)
                } catch (e: Exception) {
                    Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return binding.root
    }
}