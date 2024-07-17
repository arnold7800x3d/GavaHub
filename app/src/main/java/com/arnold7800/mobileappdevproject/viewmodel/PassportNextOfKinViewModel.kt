package com.arnold7800.mobileappdevproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.arnold7800.mobileappdevproject.room.gavahubdatabase.ApplicantDetailsDatabase
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportNextOfKinDetailsApplication
import com.arnold7800.mobileappdevproject.room.repository.PassportNextOfKinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PassportNextOfKinViewModel(application: Application): AndroidViewModel(application) {
    private val repository: PassportNextOfKinRepository

    init{
        val passKinDao = ApplicantDetailsDatabase.getDatabase(application).passportNextOfKinDetailsDAO()
        repository = PassportNextOfKinRepository(passKinDao)
    }

    fun insertApplicantDetails(application: PassportNextOfKinDetailsApplication) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Passport Next Of Kin View Model", "Inserting: $application") // logging before inserting data
            repository.insertApplicantsDetails(application)
            Log.d("Passport Next Of Kin View Model", "Inserted successfully") // log after inserting data
        }
    }
}