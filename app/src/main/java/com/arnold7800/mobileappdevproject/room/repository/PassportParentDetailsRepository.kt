package com.arnold7800.mobileappdevproject.room.repository

import android.util.Log
import com.arnold7800.mobileappdevproject.room.daoclasses.PassportParentDetailsDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportParentDetailsApplication
import javax.inject.Inject

class PassportParentDetailsRepository @Inject constructor(private val passParentDao: PassportParentDetailsDAO) {

    suspend fun insertApplicantsDetails(application: PassportParentDetailsApplication) {
        Log.d("Passport Parent Details Repository", "Inserting: $application")
        passParentDao.insertApplicantDetails(application)
    }
}