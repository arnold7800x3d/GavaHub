package com.arnold7800.mobileappdevproject.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface PassportDAO {
    @Insert
    suspend fun insertApplicantDetails(application: PassportApplication):Long

    @Update
    suspend fun updateApplicantDetails(application: PassportApplication)

}