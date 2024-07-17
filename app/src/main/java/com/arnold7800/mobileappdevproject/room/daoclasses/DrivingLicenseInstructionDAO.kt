package com.arnold7800.mobileappdevproject.room.daoclasses

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.arnold7800.mobileappdevproject.room.entityclasses.DrivingLicenseInstructionApplication

@Dao
interface DrivingLicenseInstructionDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertApplicantDetails(application: DrivingLicenseInstructionApplication): Long

    @Update
    suspend fun updateApplicantDetails(application: DrivingLicenseInstructionApplication)
}