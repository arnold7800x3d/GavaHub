package com.arnold7800.mobileappdevproject.ui.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.arnold7800.mobileappdevproject.R
import com.arnold7800.mobileappdevproject.databinding.FragmentBusinessNameRegBinding
import com.arnold7800.mobileappdevproject.room.entityclasses.BusinessNameRegistrationApplication
import com.arnold7800.mobileappdevproject.viewmodel.BusinessNameRegistrationViewModel

class BusinessNameRegFragment : Fragment() {
    private lateinit var binding: FragmentBusinessNameRegBinding
    private lateinit var businessNameViewModel: BusinessNameRegistrationViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_business_name_reg, container, false)

        businessNameViewModel = ViewModelProvider(this).get(BusinessNameRegistrationViewModel::class.java)
        //the click event on button
        binding.businessNameRegbutton.setOnClickListener {
            insertDataToDatabase {
                it.findNavController()
                    .navigate(R.id.action_businessNameRegFragment_to_businessNameRegPaymentFragment)
            }
        }
        return binding.root
    }

    private fun insertDataToDatabase(onInsertComplete: (View) -> Unit) {
        val applicantAName = binding.busRegName1editTextText.text.toString()
        val applicantAIdNo = binding.busRegNameID1editTextNumber.text.toString()
        val applicantBName = binding.busRegName2editTextText.text.toString()
        val applicantBIdNo = binding.BusRegNameID2editTextNumber.text.toString()
        val applicantCName = binding.busRegName3editTextText.text.toString()
        val applicantCIdNo = binding.busRegNameID4editTextNumber.text.toString()
        val applicantDName = binding.busRegName4editTextText.text.toString()
        val applicantDIdNo = binding.busRegNameID3editTextNumber.text.toString()
        val businessName = binding.busRegBusinessNameeditTextText.text.toString()
        val businessAddress = binding.busRegNameeditTextTextPostalAddress.text.toString()
        val zipCode = binding.busRegNameZipCodeeditTextNumberSigned.text.toString()

        if(inputCheck(applicantAName, businessName)){
            val businessNameApplicants = BusinessNameRegistrationApplication(0, applicantAName, Integer.parseInt(applicantAIdNo), applicantBName, Integer.parseInt(applicantBIdNo), applicantCName, Integer.parseInt(applicantCIdNo), applicantDName, Integer.parseInt(applicantDIdNo), businessName, businessAddress, Integer.parseInt(zipCode) )

            businessNameViewModel.insertApplicantDetails(businessNameApplicants)
            Toast.makeText(requireContext(), "Details successfully added!!", Toast.LENGTH_LONG ).show()
            onInsertComplete(binding.root)
        }else {
            Toast.makeText(requireContext(), "There was an error capturing your details.", Toast.LENGTH_LONG).show()
        }

    }

    //ensure at least one applicant
    private fun inputCheck(applicantAName: String, businessName: String): Boolean {
        return !(TextUtils.isEmpty(applicantAName) && TextUtils.isEmpty(businessName))
    }
}