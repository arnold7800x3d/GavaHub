package com.arnold7800.mobileappdevproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.arnold7800.mobileappdevproject.databinding.FragmentNationalIDBinding

class NationalIDFragment : Fragment() {

    private lateinit var binding: FragmentNationalIDBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_national_i_d, container, false)

        //button on click event
        binding.idNextbutton3.setOnClickListener{
            it.findNavController().navigate(R.id.action_nationalIDFragment_to_nationalIDSecondFragment)
        }
        return binding.root
    }

}