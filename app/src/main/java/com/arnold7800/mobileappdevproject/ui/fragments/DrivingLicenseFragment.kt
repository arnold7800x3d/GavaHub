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
import com.arnold7800.mobileappdevproject.databinding.FragmentDrivingLicenseBinding
import com.arnold7800.mobileappdevproject.room.entityclasses.DrivingLicenseApplication
import com.arnold7800.mobileappdevproject.viewmodel.DrivingLicenseViewModel

class DrivingLicenseFragment : Fragment() {

    private lateinit var binding: FragmentDrivingLicenseBinding
    private lateinit var drivingLicenseViewModel: DrivingLicenseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_driving_license, container, false)

        drivingLicenseViewModel = ViewModelProvider(this).get(DrivingLicenseViewModel::class.java)

        //on click event
        binding.dLNextbutton.setOnClickListener {
            insertDataToDatabase {
                it.findNavController()
                    .navigate(R.id.action_drivingLicenseFragment_to_drivingLicenseInstructionFragment)
            }
        }
        return binding.root
    }

    private fun insertDataToDatabase(onInsertComplete: (View) -> Unit) {
        val applicationNature = binding.dLReneworFirsteditTextText3.text.toString()
        val applicantName = binding.dLNameeditTextText.text.toString()
        val applicantPhone = binding.dLPhoneeditTextPhone.text.toString().toInt()
        val applicantEmail = binding.dLEmaileditTextTextEmailAddress.text.toString()
        val applicantDob = binding.dLDateeditTextDate.text.toString().toInt()
        val applicantIdNo = binding.dLIDeditTextNumber.text.toString().toInt()
        val applicantSex = binding.dLSexeditTextText2.text.toString()
        val zipCode = binding.dLZipeditTextNumber2.text.toString().toInt()
        val applicantAddress = binding.dLZipeditTextNumber2.text.toString()

        if (inputCheck(applicantName, applicantEmail)) {
            val dLApplicants = DrivingLicenseApplication(
                0,
                applicationNature,
                applicantName,
                applicantPhone,
                applicantEmail,
                applicantDob,
                applicantIdNo,
                applicantSex,
                zipCode,
                applicantAddress,
            )

            drivingLicenseViewModel.insertApplicantDetails(dLApplicants)
            Toast.makeText(requireContext(), "Details successfully added!!", Toast.LENGTH_LONG)
                .show()
            onInsertComplete(binding.root)
        } else {
            Toast.makeText(
                requireContext(),
                "There was an error capturing your details.",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun inputCheck(applicantName: String, applicantEmail: String): Boolean {
        return !(TextUtils.isEmpty(applicantName) && TextUtils.isEmpty(applicantEmail))
    }
}