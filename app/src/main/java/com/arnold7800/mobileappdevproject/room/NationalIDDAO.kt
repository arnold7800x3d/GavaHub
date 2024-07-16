package com.arnold7800.mobileappdevproject.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface NationalIDDAO {
    @Insert
    suspend fun insertApplicantDetails(application: NationalIDApplication):Long

    @Update
    suspend fun updateApplicantDetails(application: NationalIDApplication)

}