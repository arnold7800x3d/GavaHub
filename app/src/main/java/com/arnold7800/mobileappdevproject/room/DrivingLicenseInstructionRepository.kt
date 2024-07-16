package com.arnold7800.mobileappdevproject.room

import android.util.Log
import javax.inject.Inject

class DrivingLicenseInstructionRepository @Inject constructor(private val dLInstructionDao: DrivingLicenseInstructionDAO){


    suspend fun insertApplicantsDetails(application: DrivingLicenseInstructionApplication) {
        Log.d("Driving License Instruction Repository", "Inserting: $application")
        dLInstructionDao.insertApplicantDetails(application)
    }

    suspend fun updateApplicantsDetails(application: DrivingLicenseInstructionApplication) {
        dLInstructionDao.updateApplicantDetails(application)
    }
}