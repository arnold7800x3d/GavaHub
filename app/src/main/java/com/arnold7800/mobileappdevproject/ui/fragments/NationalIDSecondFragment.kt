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
import com.arnold7800.mobileappdevproject.databinding.FragmentNationalIDSecondBinding
import com.arnold7800.mobileappdevproject.room.entityclasses.NationalIDApplicationParentDetails
import com.arnold7800.mobileappdevproject.viewmodel.NationalIDParentDetailsViewModel

class NationalIDSecondFragment : Fragment() {
    private lateinit var binding: FragmentNationalIDSecondBinding
    private lateinit var natIDParentViewModel: NationalIDParentDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_national_i_d_second,
            container,
            false
        )

        natIDParentViewModel =
            ViewModelProvider(this).get(NationalIDParentDetailsViewModel::class.java)
        //button on click event
        binding.id2Nextbutton3.setOnClickListener {
            insertDataToDatabase {
                it.findNavController()
                    .navigate(R.id.action_nationalIDSecondFragment_to_nationalIDPaymentFragment)
            }
        }
        return binding.root
    }

    private fun insertDataToDatabase(onInsertComplete: (View) -> Unit) {
        val motherName = binding.id2MothereditTextText.text.toString()
        val motherIdNo = binding.id2ID2editTextNumber5.text.toString().toInt()
        val motherDob = binding.id2Date1editTextDate4.text.toString()
        val motherDod = binding.editTextDate.text.toString()
        val fatherName = binding.id2FathereditTextText3.text.toString()
        val fatherIdNo = binding.id2ID2editTextNumber5.text.toString().toInt()
        val fatherDob = binding.id2Date2editTextNumber6.text.toString()
        val fatherDod = binding.id2Date3editTextDate2.text.toString()
        val guardianName = binding.id2GuardianeditTextText4.text.toString()
        val guardianIdNo = binding.editTextNumber7.text.toString().toInt()
        val guardianDob = binding.editTextDate3.text.toString()
        val guardianDod = binding.editTextDate5.text.toString()
        val guardianRelationship = binding.editTextText5.text.toString()

        if (inputCheck(motherName, fatherName)) {
            val nationalIdParentDetails = NationalIDApplicationParentDetails(
                0,
                motherName,
                motherIdNo,
                motherDob,
                motherDod,
                fatherName,
                fatherIdNo,
                fatherDob,
                fatherDod,
                guardianName,
                guardianIdNo,
                guardianDob,
                guardianDod,
                guardianRelationship
            )
            natIDParentViewModel.insertApplicantDetails(nationalIdParentDetails)
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

    private fun inputCheck(motherName: String, fatherName: String): Boolean {
        return !(TextUtils.isEmpty(motherName) && TextUtils.isEmpty(fatherName))
    }
}
