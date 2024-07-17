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
import com.arnold7800.mobileappdevproject.databinding.FragmentPassportThirdBinding
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportRecommenderDetailsApplication
import com.arnold7800.mobileappdevproject.viewmodel.PassportRecommenderDetailsViewModel

class PassportThirdFragment : Fragment() {
    private lateinit var binding: FragmentPassportThirdBinding
    private lateinit var passRecViewModel: PassportRecommenderDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_passport_third, container, false)

        passRecViewModel =
            ViewModelProvider(this).get(PassportRecommenderDetailsViewModel::class.java)

        binding.passportRecommenderNextbutton3.setOnClickListener {
            insertDataToDatabase {
                it.findNavController()
                    .navigate(R.id.action_passportThirdFragment_to_passportFourthFragment)
            }
        }
        return binding.root
    }

    private fun insertDataToDatabase(onInsertComplete: (View) -> Unit) {
        val recommenderName = binding.passportRecommenderNameeditTextText.text.toString()
        val recommenderDoB = binding.passportRecommenderDOBeditTextDate2.text.toString()
        val recommenderPhoneNo =
            binding.passportRecommenderPhoneeditTextNumber2.text.toString().toInt()
        val recommenderSex = binding.passportRecommenderSexeditTextText3.text.toString()
        val recommenderId = binding.passportRecommenderIDeditTextNumber3.text.toString().toInt()

        if (inputCheck(recommenderName)) {
            val passRecApplicants = PassportRecommenderDetailsApplication(
                0,
                recommenderName,
                recommenderDoB,
                recommenderPhoneNo,
                recommenderSex,
                recommenderId
            )

            passRecViewModel.insertApplicantDetails(passRecApplicants)
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

    private fun inputCheck(recommenderName: String): Boolean {
        return !(TextUtils.isEmpty(recommenderName))
    }
}
