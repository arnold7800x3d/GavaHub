package com.arnold7800.mobileappdevproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.arnold7800.mobileappdevproject.room.gavahubdatabase.ApplicantDetailsDatabase
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportApplicantDetailsApplication
import com.arnold7800.mobileappdevproject.room.repository.PassportApplicantDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PassportApplicantDetailsViewModel (application: Application): AndroidViewModel(application) {
    private val repository: PassportApplicantDetailsRepository

    init {
        val passAppDao =
            ApplicantDetailsDatabase.getDatabase(application).passportApplicantDetailsDAO()
        repository = PassportApplicantDetailsRepository(passAppDao)
    }

    fun insertApplicantDetails(application: PassportApplicantDetailsApplication) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Passport Applicant Details View Model", "Inserting: $application") // logging before inserting data
            repository.insertApplicantsDetails(application)
            Log.d("Passport Applicant Details View Model", "Inserted successfully") // log after inserting data
        }
    }

}