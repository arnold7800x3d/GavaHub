package com.arnold7800.mobileappdevproject.room.repository

import android.util.Log
import com.arnold7800.mobileappdevproject.room.daoclasses.PassportRecommenderDetailsDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportRecommenderDetailsApplication
import javax.inject.Inject

class PassportRecommenderDetailsRepository @Inject constructor(private val passRecDao: PassportRecommenderDetailsDAO) {

    suspend fun insertApplicantsDetails(application: PassportRecommenderDetailsApplication) {
        Log.d("BusinessRegRepository", "Inserting: $application")
        passRecDao.insertApplicantDetails(application)
    }
}