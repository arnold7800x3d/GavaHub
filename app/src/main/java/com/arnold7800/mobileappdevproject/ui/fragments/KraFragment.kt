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
import com.arnold7800.mobileappdevproject.databinding.FragmentKraBinding
import com.arnold7800.mobileappdevproject.room.entityclasses.KraApplication
import com.arnold7800.mobileappdevproject.viewmodel.KraViewModel

class KraFragment : Fragment() {

    private lateinit var binding: FragmentKraBinding
    private lateinit var kraViewModel: KraViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kra, container, false)

        kraViewModel = ViewModelProvider(this).get(KraViewModel::class.java)
        //handle click event on button
        binding.kraNextbutton.setOnClickListener {
            insertDataToDatabase {
                it.findNavController().navigate(R.id.action_kraFragment_to_kraPaymentFragment)
            }
        }
        return binding.root
    }

    private fun insertDataToDatabase(onInsertComplete: (View) -> Unit) {
        val applicationNature = binding.residencyEditText.text.toString()
        val applicantName = binding.kraNameEditText.text.toString()
        val applicantEmail = binding.kraeditTextTextEmailAddress.text.toString()
        val applicantDob = binding.kraDateeditTextDate.text.toString()
        val applicantIdNo = binding.kraIDNoeditTextNumber.text.toString()
        val applicantSex = binding.kraSexeditTextText.text.toString()
        val zipCode = binding.kraZipCodeeditTextNumber.text.toString()
        val applicantAddress = binding.kraeditTextTextPostalAddress.text.toString()
        val pinType = binding.kraTypeeditTextText.text.toString()

        if(inputCheck(applicantName, applicantEmail)) {
            val kraApplicants = KraApplication(0, applicationNature, applicantName, applicantEmail, applicantDob, applicantIdNo, applicantSex, zipCode, applicantAddress, pinType)

            kraViewModel.insertApplicantDetails(kraApplicants)
            Toast.makeText(requireContext(), "Details successfully added!!", Toast.LENGTH_LONG)
                .show()
            binding.root.postDelayed({
                onInsertComplete(binding.root)
            }, 1000)
        } else {
            Toast.makeText(requireContext(), "There was an error capturing your details.", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(applicantName: String, applicantEmail: String): Boolean {
        return !(TextUtils.isEmpty(applicantName) && TextUtils.isEmpty(applicantEmail))
    }


}