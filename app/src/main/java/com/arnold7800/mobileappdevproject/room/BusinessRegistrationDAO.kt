package com.arnold7800.mobileappdevproject.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface BusinessRegistrationDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertApplicantDetails(application: BusinessRegistrationApplication):Long

    @Update
    suspend fun updateApplicantDetails(application: BusinessRegistrationApplication)
}