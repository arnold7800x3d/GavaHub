package com.arnold7800.mobileappdevproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.arnold7800.mobileappdevproject.R
import com.arnold7800.mobileappdevproject.databinding.FragmentLogoutBinding

class LogoutFragment : Fragment() {

    private lateinit var binding: FragmentLogoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_logout, container, false)

        binding.logoutbutton3.setOnClickListener(){
            it.findNavController().navigate(R.id.action_logoutFragment_to_mainActivity)
        }
        return binding.root
    }

}