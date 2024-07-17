package com.arnold7800.mobileappdevproject.room.repository

import android.util.Log
import com.arnold7800.mobileappdevproject.room.daoclasses.KraDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.KraApplication
import javax.inject.Inject

class KraRepository @Inject constructor(private val kraDao: KraDAO){

    suspend fun insertApplicantDetails(application: KraApplication) {
        Log.d("Kra Repository", "Inserting $application")
        kraDao.insertApplicantDetails(application)
    }


}