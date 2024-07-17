package com.arnold7800.mobileappdevproject.room.repository

import android.util.Log
import com.arnold7800.mobileappdevproject.room.daoclasses.PassportNextOfKinDetailsDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportNextOfKinDetailsApplication
import javax.inject.Inject

class PassportNextOfKinRepository @Inject constructor(private val passKinDao: PassportNextOfKinDetailsDAO) {

    suspend fun insertApplicantsDetails(application: PassportNextOfKinDetailsApplication) {
        Log.d("BusinessRegRepository", "Inserting: $application")
        passKinDao.insertApplicantDetails(application)
    }
}