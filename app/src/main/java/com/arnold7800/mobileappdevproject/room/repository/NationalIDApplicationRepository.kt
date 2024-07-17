package com.arnold7800.mobileappdevproject.room.repository

import android.util.Log
import com.arnold7800.mobileappdevproject.room.daoclasses.NationalIDDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.NationalIDApplication
import javax.inject.Inject

class NationalIDApplicationRepository @Inject constructor(private var natIdDao: NationalIDDAO){

    suspend fun insertApplicantsDetails(application: NationalIDApplication) {
        Log.d("National ID repository", "Inserting: $application")
        natIdDao.insertApplicantDetails(application)
    }
}