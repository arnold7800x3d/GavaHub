package com.arnold7800.mobileappdevproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.navigation.findNavController
import com.arnold7800.mobileappdevproject.databinding.FragmentKraBinding

class KraFragment : Fragment() {

    private lateinit var binding: FragmentKraBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kra, container, false)

        //handle click event on button
        binding.kraNextbutton.setOnClickListener{
            it.findNavController().navigate(R.id.action_kraFragment_to_kraPaymentFragment)
        }
        return binding.root
    }
}