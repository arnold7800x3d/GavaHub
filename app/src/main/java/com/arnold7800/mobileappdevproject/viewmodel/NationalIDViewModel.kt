package com.arnold7800.mobileappdevproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.arnold7800.mobileappdevproject.room.gavahubdatabase.ApplicantDetailsDatabase
import com.arnold7800.mobileappdevproject.room.entityclasses.NationalIDApplication
import com.arnold7800.mobileappdevproject.room.repository.NationalIDApplicationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NationalIDViewModel(application: Application): AndroidViewModel(application) {

    private val repository: NationalIDApplicationRepository

    init{
        val natIdDao = ApplicantDetailsDatabase.getDatabase(application).nationalIDApplicationDAO()
        repository = NationalIDApplicationRepository(natIdDao)
    }

    fun insertApplicantDetails(application: NationalIDApplication) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("National ID View Model", "Inserting: $application") // logging before inserting data
            repository.insertApplicantsDetails(application)
            Log.d("National ID View Model", "Inserted successfully") // log after inserting data
        }
    }
}