package com.arnold7800.mobileappdevproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.arnold7800.mobileappdevproject.room.gavahubdatabase.ApplicantDetailsDatabase
import com.arnold7800.mobileappdevproject.room.entityclasses.DrivingLicenseApplication
import com.arnold7800.mobileappdevproject.room.repository.DrivingLicenseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DrivingLicenseViewModel(application: Application): AndroidViewModel(application){
    private val repository: DrivingLicenseRepository

    init{
        val drivingLicenseDao = ApplicantDetailsDatabase.getDatabase(application).drivingLicenseApplicationDAO()
        repository = DrivingLicenseRepository(drivingLicenseDao)
    }

    fun insertApplicantDetails(application: DrivingLicenseApplication) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Driving License View Model", "Inserting: $application")
            repository.insertApplicantsDetails(application)
            Log.d("Driving License View Model", "Inserted successfully")
        }
    }


}