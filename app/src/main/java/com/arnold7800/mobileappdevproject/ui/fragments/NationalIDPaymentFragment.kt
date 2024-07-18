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
import com.arnold7800.mobileappdevproject.databinding.FragmentNationalIDPaymentBinding
import kotlinx.coroutines.launch

class NationalIDPaymentFragment : Fragment() {
    private lateinit var binding: FragmentNationalIDPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_national_i_d_payment, container, false)

        binding.idPaymentbutton3.setOnClickListener { view: View ->
            val amount = 100
            val phone = binding.busregpaymenteditTextPhone.text.toString()
            val type = "National ID Registration"

            lifecycleScope.launch {
                try {
                    val response = NetworkModule.darajaApi.initiatePayment(amount, phone, type)
                    Toast.makeText(context, "Processing payment....", Toast.LENGTH_SHORT).show()

                    findNavController().navigate(R.id.action_nationalIDPaymentFragment_to_homeFragment)
                } catch (e: Exception) {
                    Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return binding.root
    }
}