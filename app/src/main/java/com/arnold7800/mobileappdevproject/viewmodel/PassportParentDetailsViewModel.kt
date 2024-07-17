package com.arnold7800.mobileappdevproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.arnold7800.mobileappdevproject.room.gavahubdatabase.ApplicantDetailsDatabase
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportParentDetailsApplication
import com.arnold7800.mobileappdevproject.room.repository.PassportParentDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PassportParentDetailsViewModel(application: Application): AndroidViewModel(application) {

    private val repository: PassportParentDetailsRepository

    init{
        val passParentDao = ApplicantDetailsDatabase.getDatabase(application).passportParentDetailsDAO()
        repository = PassportParentDetailsRepository(passParentDao)
    }

    fun insertApplicantDetails(application: PassportParentDetailsApplication) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Passport Parent Details View Model", "Inserting: $application") // logging before inserting data
            repository.insertApplicantsDetails(application)
            Log.d("Passport Parent Details View Model", "Inserted successfully") // log after inserting data
        }
    }
}