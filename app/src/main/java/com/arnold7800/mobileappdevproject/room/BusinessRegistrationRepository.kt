package com.arnold7800.mobileappdevproject.room

import android.util.Log
import javax.inject.Inject

class BusinessRegistrationRepository @Inject constructor(private val busRegDao: BusinessRegistrationDAO){


    suspend fun insertApplicantsDetails(application: BusinessRegistrationApplication) {
        Log.d("BusinessRegRepository", "Inserting: $application")
        busRegDao.insertApplicantDetails(application)
    }

    suspend fun updateApplicantsDetails(application: BusinessRegistrationApplication) {
        busRegDao.updateApplicantDetails(application)
    }
}