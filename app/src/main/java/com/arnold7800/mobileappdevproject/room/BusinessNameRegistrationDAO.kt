package com.arnold7800.mobileappdevproject.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface BusinessNameRegistrationDAO {
    @Insert
    suspend fun insertApplicantDetails(application: BusinessNameRegistrationApplication):Long

    @Update
    suspend fun updateApplicantDetails(application: BusinessNameRegistrationApplication)
}