package com.arnold7800.mobileappdevproject.room.daoclasses

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportRecommenderDetailsApplication

@Dao
interface PassportRecommenderDetailsDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertApplicantDetails(application: PassportRecommenderDetailsApplication):Long
}