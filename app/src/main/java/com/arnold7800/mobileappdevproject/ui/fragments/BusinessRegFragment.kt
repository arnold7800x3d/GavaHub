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
import com.arnold7800.mobileappdevproject.databinding.FragmentBusinessRegBinding
import com.arnold7800.mobileappdevproject.room.entityclasses.BusinessRegistrationApplication
import com.arnold7800.mobileappdevproject.viewmodel.BusinessRegistrationViewModel

class BusinessRegFragment : Fragment() {
    private lateinit var binding: FragmentBusinessRegBinding
    private lateinit var busRegViewModel: BusinessRegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_business_reg, container, false)

        busRegViewModel = ViewModelProvider(this).get(BusinessRegistrationViewModel::class.java)

        //on click event
        binding.busRNextbutton.setOnClickListener {
            insertDataToDatabase {
                it.findNavController()
                    .navigate(R.id.action_businessRegFragment_to_businessRegFileUploadFragment)
            }
        }
        return binding.root
    }

    private fun insertDataToDatabase(onInsertComplete: (View) -> Unit) {
        val applicantAName = binding.busR1editTextText.text.toString()
        val applicantAIdNo = binding.busID1editTextNumber.text.toString()
        val applicantBName = binding.busR2editTextText2.text.toString()
        val applicantBIdNo = binding.busID2editTextNumber.text.toString()
        val applicantCName = binding.busR3editTextText3.text.toString()
        val applicantCIdNo = binding.busID3editTextNumber.text.toString()
        val applicantDName = binding.busR4editTextText4.text.toString()
        val applicantDIdNo = binding.busID4editTextNumber.text.toString()
        val businessName = binding.busRegistrationNameeditTextText.text.toString()

        if(inputCheck(applicantAName,businessName)){
            //Creating the object
            val businessApplicants = BusinessRegistrationApplication(0, applicantAName, Integer.parseInt(applicantAIdNo), applicantBName, Integer.parseInt(applicantBIdNo), applicantCName, Integer.parseInt(applicantCIdNo), applicantDName, Integer.parseInt(applicantDIdNo), businessName)

            //Add data to database
            busRegViewModel.insertApplicantDetails(businessApplicants)
            Toast.makeText(requireContext(), "Details successfully added!!", Toast.LENGTH_LONG)
                .show()
            binding.root.postDelayed({
                onInsertComplete(binding.root)
            }, 1000)
        }else {
            Toast.makeText(requireContext(), "There was an error capturing your details.", Toast.LENGTH_LONG).show()
        }

    }

    //ensure at least one applicant
    private fun inputCheck(applicantAName: String, businessName: String): Boolean {
        return !(TextUtils.isEmpty(applicantAName) && TextUtils.isEmpty(businessName))
    }
}