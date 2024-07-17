package com.arnold7800.mobileappdevproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.arnold7800.mobileappdevproject.room.gavahubdatabase.ApplicantDetailsDatabase
import com.arnold7800.mobileappdevproject.room.entityclasses.BusinessNameRegistrationApplication
import com.arnold7800.mobileappdevproject.room.repository.BusinessNameRegistrationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BusinessNameRegistrationViewModel(application: Application): AndroidViewModel(application) {

    private val repository: BusinessNameRegistrationRepository

    init{
        val busNameRegDao = ApplicantDetailsDatabase.getDatabase(application).businessNameRegistrationApplicationDAO()
        repository = BusinessNameRegistrationRepository(busNameRegDao)
    }

    fun insertApplicantDetails(application: BusinessNameRegistrationApplication) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("BusinessNameRegistrationViewModel", "Inseting: $application") //log before inseting data
            repository.insertApplicantsDetails(application)
            Log.d("BusinessNameRegistrationViewModel", "Inserted successfully")
        }
    }
}