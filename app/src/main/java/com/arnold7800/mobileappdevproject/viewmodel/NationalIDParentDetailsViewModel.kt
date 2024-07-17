package com.arnold7800.mobileappdevproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.arnold7800.mobileappdevproject.room.gavahubdatabase.ApplicantDetailsDatabase
import com.arnold7800.mobileappdevproject.room.entityclasses.NationalIDApplicationParentDetails
import com.arnold7800.mobileappdevproject.room.repository.NationalIDApplicationParentDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NationalIDParentDetailsViewModel(application: Application): AndroidViewModel(application){

    private val repository: NationalIDApplicationParentDetailsRepository

    init {
        val natIDParentDao = ApplicantDetailsDatabase.getDatabase(application).nationalIDParentDetailsDAO()
        repository = NationalIDApplicationParentDetailsRepository(natIDParentDao)
    }
    fun insertApplicantDetails(application: NationalIDApplicationParentDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("National ID Parent Details View Model", "Inserting: $application") // logging before inserting data
            repository.insertApplicantsDetails(application)
            Log.d("National ID Parent Details View Model", "Inserted successfully") // log after inserting data
        }
    }
}