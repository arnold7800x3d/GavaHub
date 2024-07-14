package com.arnold7800.mobileappdevproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.arnold7800.mobileappdevproject.databinding.FragmentPassportBinding
import com.arnold7800.mobileappdevproject.databinding.FragmentPassportThirdBinding

class PassportThirdFragment : Fragment() {
    private lateinit var binding: FragmentPassportThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_passport_third, container, false)


        binding.passportRecommenderNextbutton3.setOnClickListener{
            it.findNavController().navigate(R.id.action_passportThirdFragment_to_passportFourthFragment)
        }
        return binding.root
    }
}