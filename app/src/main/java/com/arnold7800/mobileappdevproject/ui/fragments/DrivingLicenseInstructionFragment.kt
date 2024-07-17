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
import com.arnold7800.mobileappdevproject.databinding.FragmentDrivingLicenseInstructionBinding
import com.arnold7800.mobileappdevproject.room.entityclasses.DrivingLicenseInstructionApplication
import com.arnold7800.mobileappdevproject.viewmodel.DrivingLicenseInstructionViewModel

class DrivingLicenseInstructionFragment : Fragment() {
    private lateinit var binding: FragmentDrivingLicenseInstructionBinding
    private lateinit var dLInstructionViewModel: DrivingLicenseInstructionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_driving_license_instruction,
            container,
            false
        )

        dLInstructionViewModel =
            ViewModelProvider(this).get(DrivingLicenseInstructionViewModel::class.java)

        //on click event
        binding.dLPaymentbutton3.setOnClickListener {
            insertDataToDatabase {
                it.findNavController()
                    .navigate(R.id.action_drivingLicenseInstructionFragment_to_drivingLicensePaymentFragment)
            }
        }
        return binding.root
    }

    private fun insertDataToDatabase(onInsertComplete: (View) -> Unit) {
        val instructor = binding.dlInstructorNameeditTextText.text.toString()
        val instructorNtsaNo = binding.dLInstructorNTSANumbereditTextText2.text.toString().toInt()
        val school = binding.dLSchooleditTextText4.text.toString()
        val address = binding.dLSchoolAddresseditTextTextPostalAddress.text.toString()
        val category = binding.dLLicenseCategoryeditTextText3.text.toString()


        if (inputCheck(instructor, school)) {
            val dlInstruction = DrivingLicenseInstructionApplication(
                0,
                instructor,
                instructorNtsaNo,
                school,
                address,
                category
            )

            dLInstructionViewModel.insertApplicantDetails(dlInstruction)
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

    private fun inputCheck(instructor: String, school: String): Boolean {
        return !(TextUtils.isEmpty(instructor) && TextUtils.isEmpty(school))
    }
}
