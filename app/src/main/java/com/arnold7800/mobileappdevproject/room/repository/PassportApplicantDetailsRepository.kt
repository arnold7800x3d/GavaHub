package com.arnold7800.mobileappdevproject.room.repository

import android.util.Log
import com.arnold7800.mobileappdevproject.room.daoclasses.PassportApplicantDetailsDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportApplicantDetailsApplication
import javax.inject.Inject

class PassportApplicantDetailsRepository @Inject constructor(private val passAppDao: PassportApplicantDetailsDAO){

    suspend fun insertApplicantsDetails(application: PassportApplicantDetailsApplication) {
        Log.d("Passport Applicant Details Repository", "Inserting: $application")
        passAppDao.insertApplicantDetails(application)
    }
}