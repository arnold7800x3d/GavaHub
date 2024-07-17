package com.arnold7800.mobileappdevproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.arnold7800.mobileappdevproject.room.gavahubdatabase.ApplicantDetailsDatabase
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportRecommenderDetailsApplication
import com.arnold7800.mobileappdevproject.room.repository.PassportRecommenderDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PassportRecommenderDetailsViewModel(application: Application): AndroidViewModel(application) {

    private val repository: PassportRecommenderDetailsRepository

    init{
        val passRecDao = ApplicantDetailsDatabase.getDatabase(application).passportRecommenderDetailsDAO()
        repository = PassportRecommenderDetailsRepository(passRecDao)
    }

    fun insertApplicantDetails(application: PassportRecommenderDetailsApplication) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Passport Recommender View Model", "Inserting: $application") // logging before inserting data
            repository.insertApplicantsDetails(application)
            Log.d("Passport Recommender View Model", "Inserted successfully") // log after inserting data
        }
    }
}