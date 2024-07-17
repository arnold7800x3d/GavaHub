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
import com.arnold7800.mobileappdevproject.databinding.FragmentPassportBinding
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportApplicantDetailsApplication
import com.arnold7800.mobileappdevproject.viewmodel.PassportApplicantDetailsViewModel

class PassportFragment : Fragment() {

    private lateinit var binding: FragmentPassportBinding
    private lateinit var passAppViewModel: PassportApplicantDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_passport, container, false)

        passAppViewModel =
            ViewModelProvider(this).get(PassportApplicantDetailsViewModel::class.java)

        binding.passportNextbutton3.setOnClickListener {
            insertDataToDatabase {
                it.findNavController()
                    .navigate(R.id.action_passportFragment_to_passportSecondFragment)
            }
        }
        return binding.root
    }

    private fun insertDataToDatabase(onInsertComplete: (View) -> Unit) {
        val applicantName = binding.passportNameeditTextText.text.toString()
        val applicantDob = binding.passportDobeditTextDate2.text.toString()
        val applicantSex = binding.passportSexeditTextText3.text.toString()
        val applicantPob = binding.editTextText4.text.toString()
        val applicantPhoneNo = binding.passportPhoneNoeditTextNumber2.text.toString().toInt()
        val zipCode = binding.passportZipeditTextNumber3.text.toString().toInt()

        if (inputCheck(applicantName)) {
            val passportApplicants = PassportApplicantDetailsApplication(
                0,
                applicantName,
                applicantDob,
                applicantSex,
                applicantPob,
                applicantPhoneNo,
                zipCode
            )

            passAppViewModel.insertApplicantDetails(passportApplicants)
            Toast.makeText(requireContext(), "Details successfully added!!", Toast.LENGTH_LONG)
                .show()
            binding.root.postDelayed({
                onInsertComplete(binding.root)
            }, 1000)
        } else {
            Toast.makeText(
                requireContext(),
                "There was an error capturing your details.",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun inputCheck(applicantName: String): Boolean {
        return !(TextUtils.isEmpty(applicantName))
    }


}


