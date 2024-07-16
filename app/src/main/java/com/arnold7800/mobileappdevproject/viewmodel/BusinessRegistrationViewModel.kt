package com.arnold7800.mobileappdevproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.arnold7800.mobileappdevproject.room.ApplicantDetailsDatabase
import com.arnold7800.mobileappdevproject.room.BusinessRegistrationApplication
import com.arnold7800.mobileappdevproject.room.BusinessRegistrationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BusinessRegistrationViewModel(application: Application): AndroidViewModel(application){

    private val repository: BusinessRegistrationRepository

    init{
        val busRegDao = ApplicantDetailsDatabase.getDatabase(application).businessRegistrationApplicationDAO()
        repository = BusinessRegistrationRepository(busRegDao)
    }

    fun insertApplicantDetails(application: BusinessRegistrationApplication) {
        viewModelScope.launch(Dispatchers.IO) {Log.d("BusinessRegViewModel", "Inserting: $application") // logging before inserting data
            repository.insertApplicantsDetails(application)
            Log.d("BusinessRegViewModel", "Inserted successfully") // log after inserting data
        }
    }
}