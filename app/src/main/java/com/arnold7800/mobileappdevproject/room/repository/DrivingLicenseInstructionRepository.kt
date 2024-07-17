package com.arnold7800.mobileappdevproject.room.repository

import android.util.Log
import com.arnold7800.mobileappdevproject.room.daoclasses.DrivingLicenseInstructionDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.DrivingLicenseInstructionApplication
import javax.inject.Inject

class DrivingLicenseInstructionRepository @Inject constructor(private val dLInstructionDao: DrivingLicenseInstructionDAO){


    suspend fun insertApplicantsDetails(application: DrivingLicenseInstructionApplication) {
        Log.d("Driving License Instruction Repository", "Inserting: $application")
        dLInstructionDao.insertApplicantDetails(application)
    }


}