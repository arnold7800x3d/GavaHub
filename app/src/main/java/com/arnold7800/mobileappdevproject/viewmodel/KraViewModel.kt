package com.arnold7800.mobileappdevproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.arnold7800.mobileappdevproject.room.gavahubdatabase.ApplicantDetailsDatabase
import com.arnold7800.mobileappdevproject.room.entityclasses.KraApplication
import com.arnold7800.mobileappdevproject.room.repository.KraRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KraViewModel (application: Application): AndroidViewModel(application){

    private val repository: KraRepository

    init{
        val kraDao = ApplicantDetailsDatabase.getDatabase(application).kraApplicationDAO()
        repository = KraRepository(kraDao)
    }

    fun insertApplicantDetails(application: KraApplication) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Kra View Model", "Inserting: $application")
            repository.insertApplicantDetails(application)
            Log.d("Kra View Model","Inserted successfully")
        }
    }
}