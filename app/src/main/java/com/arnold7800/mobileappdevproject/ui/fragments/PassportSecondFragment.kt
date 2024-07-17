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
import com.arnold7800.mobileappdevproject.databinding.FragmentPassportSecondBinding
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportParentDetailsApplication
import com.arnold7800.mobileappdevproject.viewmodel.PassportParentDetailsViewModel

class PassportSecondFragment : Fragment() {

    private lateinit var binding: FragmentPassportSecondBinding
    private lateinit var passParentViewModel: PassportParentDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_passport_second, container, false)

        passParentViewModel =
            ViewModelProvider(this).get(PassportParentDetailsViewModel::class.java)

        binding.passport2Nextbutton3.setOnClickListener {
            insertDataToDatabase {
                it.findNavController()
                    .navigate(R.id.action_passportSecondFragment_to_passportThirdFragment)
            }
        }
        return binding.root
    }

    private fun insertDataToDatabase(onInsertComplete: (View) -> Unit) {
        val motherName = binding.passport2MothereditTextText.text.toString()
        val motherId = binding.passport2ID1editTextNumber2.text.toString().toInt()
        val motherDob = binding.passport2Date1editTextDate4.text.toString()
        val motherDod = binding.passporteditTextDate5.text.toString()
        val fatherName = binding.passport2FathereditTextText3.text.toString()
        val fatherId = binding.passport2ID2editTextNumber5.text.toString().toInt()
        val fatherDob = binding.passport2Date2editTextNumber6.text.toString()
        val fatherDod = binding.passport2Date3editTextDate2.text.toString()
        val guardianName = binding.id2GuardianeditTextText4.text.toString()
        val guardianId = binding.passporteditTextNumber7.text.toString().toInt()
        val guardianDob = binding.passporteditTextDate3.text.toString()
        val guardianDod = binding.passporteditTextDate5.text.toString()
        val relationship = binding.editTextText5.text.toString()

        if (inputCheck(motherName)) {
            val passParentApplicants = PassportParentDetailsApplication(
                0,
                motherName,
                motherId,
                motherDob,
                motherDod,
                fatherName,
                fatherId,
                fatherDob,
                fatherDod,
                guardianName,
                guardianId,
                guardianDob,
                guardianDod,
                relationship
            )

            passParentViewModel.insertApplicantDetails(passParentApplicants)
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

    private fun inputCheck(motherName: String): Boolean {
        return !(TextUtils.isEmpty(motherName))
    }

}

