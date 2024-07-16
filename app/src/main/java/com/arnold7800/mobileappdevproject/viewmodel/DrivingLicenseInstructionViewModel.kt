package com.arnold7800.mobileappdevproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.arnold7800.mobileappdevproject.room.ApplicantDetailsDatabase
import com.arnold7800.mobileappdevproject.room.DrivingLicenseInstructionApplication
import com.arnold7800.mobileappdevproject.room.DrivingLicenseInstructionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DrivingLicenseInstructionViewModel (application: Application): AndroidViewModel(application){

    private val repository: DrivingLicenseInstructionRepository

    init{
        val dLInstructionDao = ApplicantDetailsDatabase.getDatabase(application).drivingLicenseInstructionDAO()
        repository = DrivingLicenseInstructionRepository(dLInstructionDao)
    }

    fun insertApplicantDetails(application: DrivingLicenseInstructionApplication) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Driving Instruction View Model", "Inserting: $application") // logging before inserting data
            repository.insertApplicantsDetails(application)
            Log.d("Driving Instruction View Model", "Inserted successfully") // log after inserting data
        }
    }
}