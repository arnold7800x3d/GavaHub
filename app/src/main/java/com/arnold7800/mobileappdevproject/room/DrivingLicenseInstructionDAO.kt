package com.arnold7800.mobileappdevproject.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface DrivingLicenseInstructionDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertApplicantDetails(application: DrivingLicenseInstructionApplication): Long

    suspend fun updateApplicantDetails(application: DrivingLicenseInstructionApplication)
}