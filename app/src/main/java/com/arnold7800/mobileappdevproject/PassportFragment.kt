package com.arnold7800.mobileappdevproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.arnold7800.mobileappdevproject.databinding.FragmentPassportBinding

class PassportFragment : Fragment() {

    private lateinit var binding: FragmentPassportBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_passport, container, false)


        binding.passportNextbutton3.setOnClickListener{
            it.findNavController().navigate(R.id.action_passportFragment_to_passportSecondFragment)
        }
        return binding.root
    }


}