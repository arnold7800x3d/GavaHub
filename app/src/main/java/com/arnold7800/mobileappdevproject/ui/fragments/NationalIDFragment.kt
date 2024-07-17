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
import com.arnold7800.mobileappdevproject.databinding.FragmentNationalIDBinding
import com.arnold7800.mobileappdevproject.room.entityclasses.NationalIDApplication
import com.arnold7800.mobileappdevproject.viewmodel.NationalIDViewModel

class NationalIDFragment : Fragment() {

    private lateinit var binding: FragmentNationalIDBinding
    private lateinit var natIDViewModel: NationalIDViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_national_i_d, container, false)

        natIDViewModel = ViewModelProvider(this).get(NationalIDViewModel::class.java)

        //button on click event
        binding.idNextbutton3.setOnClickListener {
            insertDataToDatabase {
                it.findNavController()
                    .navigate(R.id.action_nationalIDFragment_to_nationalIDSecondFragment)
            }
        }
        return binding.root
    }

    private fun insertDataToDatabase(onInsertComplete: (View) -> Unit) {
        val applicantName = binding.idNameeditTextText.text.toString()
        val applicantDob = binding.iddNameeditTextDate.text.toString()
        val applicantSex = binding.editTextText2.text.toString()
        val applicantPob = binding.idPlaceofBirtheditTextText3.text.toString()
        val applicantPhoneNo = binding.editTextNumber.text.toString().toInt()
        val zipCode = binding.idZipeditTextNumber2.text.toString().toInt()

        if (inputCheck(applicantName)) {
            val nationalIDApplicants = NationalIDApplication(
                0,
                applicantName,
                applicantDob,
                applicantSex,
                applicantPob,
                applicantPhoneNo,
                zipCode
            )

            natIDViewModel.insertApplicantDetails(nationalIDApplicants)
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

