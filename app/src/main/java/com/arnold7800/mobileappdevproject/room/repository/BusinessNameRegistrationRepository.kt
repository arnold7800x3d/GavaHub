package com.arnold7800.mobileappdevproject.room.repository

import android.util.Log
import com.arnold7800.mobileappdevproject.room.daoclasses.BusinessNameRegistrationDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.BusinessNameRegistrationApplication
import javax.inject.Inject

class BusinessNameRegistrationRepository @Inject constructor(private val busNameRegDao: BusinessNameRegistrationDAO) {


    suspend fun insertApplicantsDetails(application: BusinessNameRegistrationApplication) {
        Log.d("BusinessNameRegistrationRepository", "Inserting: $application")
        busNameRegDao.insertApplicantDetails(application)
    }

    suspend fun updateApplicantsDetails(application: BusinessNameRegistrationApplication) {
        busNameRegDao.updateApplicantDetails(application)
    }
}