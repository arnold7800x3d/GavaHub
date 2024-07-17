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
import com.arnold7800.mobileappdevproject.databinding.FragmentPassportFourthBinding
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportNextOfKinDetailsApplication
import com.arnold7800.mobileappdevproject.viewmodel.PassportNextOfKinViewModel

class PassportFourthFragment : Fragment() {
    private lateinit var binding: FragmentPassportFourthBinding
    private lateinit var passKinViewModel: PassportNextOfKinViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_passport_fourth, container, false)

        passKinViewModel = ViewModelProvider(this).get(PassportNextOfKinViewModel::class.java)

        binding.passportNextOfKinNextbutton3.setOnClickListener {
            insertDataToDatabase {
                it.findNavController()
                    .navigate(R.id.action_passportFourthFragment_to_passportFileUploadFragment)
            }
        }
        return binding.root
    }

    private fun insertDataToDatabase(onInsertComplete: (View) -> Unit) {
        val kinName = binding.passportNextOfKinNameeditTextText.text.toString()
        val kinId = binding.passportNextOfKinIDeditTextNumber2.text.toString().toInt()
        val kinDob = binding.passportNextOfKinDOBeditTextDate2.text.toString()
        val kinSex = binding.passportNextOfKinSexeditTextText3.text.toString()
        val kinPhone = binding.passportNextOfKinPhoneeditTextPhone.text.toString().toInt()
        val relationship = binding.passportNextOfKinRshpeditTextText6.text.toString()

        if (inputCheck(kinName)) {

            val kinApplicants = PassportNextOfKinDetailsApplication(0, kinName, kinId, kinDob, kinSex, kinPhone, relationship)

            passKinViewModel.insertApplicantDetails(kinApplicants)
            Toast.makeText(requireContext(), "Details successfully added!!", Toast.LENGTH_LONG ).show()
            onInsertComplete(binding.root)
        }else {
            Toast.makeText(requireContext(), "There was an error capturing your details.", Toast.LENGTH_LONG).show()
        }

        }

    private fun inputCheck(kinName: String): Boolean {
        return !(TextUtils.isEmpty(kinName))

    }
}
