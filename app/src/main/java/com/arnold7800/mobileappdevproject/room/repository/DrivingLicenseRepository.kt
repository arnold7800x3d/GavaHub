package com.arnold7800.mobileappdevproject.room.repository

import android.util.Log
import com.arnold7800.mobileappdevproject.room.daoclasses.DrivingLicenseDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.DrivingLicenseApplication
import javax.inject.Inject

class DrivingLicenseRepository @Inject constructor(private val drivingLicenseDao: DrivingLicenseDAO) {

    suspend fun insertApplicantsDetails(application: DrivingLicenseApplication) {
        Log.d("Driving License Application", "Inserting: $application")
        drivingLicenseDao.insertApplicantDetails(application)
    }


}