package com.arnold7800.mobileappdevproject.room

import android.app.Application
import android.util.Log
import javax.inject.Inject

class DrivingLicenseRepository @Inject constructor(private val drivingLicenseDao: DrivingLicenseDAO) {

    suspend fun insertApplicantsDetails(application: DrivingLicenseApplication) {
        Log.d("Driving License Application", "Inserting: $application")
        drivingLicenseDao.insertApplicantDetails(application)
    }

    suspend fun updateApplicantDetails(application: DrivingLicenseApplication) {
        drivingLicenseDao.updateApplicantDetails(application)
    }
}