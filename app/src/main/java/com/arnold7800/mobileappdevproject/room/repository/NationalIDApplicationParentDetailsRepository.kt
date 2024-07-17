package com.arnold7800.mobileappdevproject.room.repository

import android.util.Log
import com.arnold7800.mobileappdevproject.room.daoclasses.NationalIDApplicationParentDetailsDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.NationalIDApplicationParentDetails
import javax.inject.Inject

class NationalIDApplicationParentDetailsRepository @Inject constructor(private val natIDParentDao: NationalIDApplicationParentDetailsDAO){

    suspend fun insertApplicantsDetails(application: NationalIDApplicationParentDetails) {
        Log.d("National ID Application Parents Details Repository", "Inserting: $application")
        natIDParentDao.insertApplicantDetails(application)
    }
}