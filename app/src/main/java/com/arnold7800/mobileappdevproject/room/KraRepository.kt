package com.arnold7800.mobileappdevproject.room

import android.util.Log
import javax.inject.Inject

class KraRepository @Inject constructor(private val kraDao: KraDAO){

    suspend fun insertApplicantDetails(application: KraApplication) {
        Log.d("Kra Repository", "Inserting $application")
        kraDao.insertApplicantDetails(application)
    }

    suspend fun updateApplicantsDetails(application: KraApplication){
        kraDao.updateApplicantDetails(application)
    }
}