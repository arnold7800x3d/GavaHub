package com.arnold7800.mobileappdevproject.room.repository

import android.util.Log
import com.arnold7800.mobileappdevproject.room.daoclasses.BusinessRegistrationDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.BusinessRegistrationApplication
import javax.inject.Inject

class BusinessRegistrationRepository @Inject constructor(private val busRegDao: BusinessRegistrationDAO){


    suspend fun insertApplicantsDetails(application: BusinessRegistrationApplication) {
        Log.d("BusinessRegRepository", "Inserting: $application")
        busRegDao.insertApplicantDetails(application)
    }


}