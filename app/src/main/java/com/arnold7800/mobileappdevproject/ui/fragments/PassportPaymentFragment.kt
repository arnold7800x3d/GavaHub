package com.arnold7800.mobileappdevproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.arnold7800.mobileappdevproject.R
import com.arnold7800.mobileappdevproject.api.NetworkModule
import com.arnold7800.mobileappdevproject.databinding.FragmentPassportPaymentBinding
import kotlinx.coroutines.launch

class PassportPaymentFragment : Fragment() {
    private lateinit var binding: FragmentPassportPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_passport_payment, container, false)

        binding.passportAbutton3.setOnClickListener { view: View ->
            val amount = 4550
            val phone = binding.busregpaymenteditTextPhone.text.toString()
            val type = "Passport Registration"

            lifecycleScope.launch {
                try {
                    val response = NetworkModule.darajaApi.initiatePayment(amount, phone, type)
                    Toast.makeText(context, "Processing payment....", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.passportBbutton4.setOnClickListener { view: View ->
            val amount = 6050
            val phone = binding.busregpaymenteditTextPhone.text.toString()
            val type = "Passport Registration"

            lifecycleScope.launch {
                try {
                    val response = NetworkModule.darajaApi.initiatePayment(amount, phone, type)
                    Toast.makeText(context, "Processing payment....", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.passportCbutton5.setOnClickListener { view: View ->
            val amount = 7550
            val phone = binding.busregpaymenteditTextPhone.text.toString()
            val type = "Passport Registration"

            lifecycleScope.launch {
                try {
                    val response = NetworkModule.darajaApi.initiatePayment(amount, phone, type)
                    Toast.makeText(context, "Processing payment....", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return binding.root
    }
}