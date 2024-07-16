package com.arnold7800.mobileappdevproject.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface DrivingLicenseInstructionDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertApplicantDetails(application: DrivingLicenseInstructionApplication): Long

    @Update
    suspend fun updateApplicantDetails(application: DrivingLicenseInstructionApplication)
}