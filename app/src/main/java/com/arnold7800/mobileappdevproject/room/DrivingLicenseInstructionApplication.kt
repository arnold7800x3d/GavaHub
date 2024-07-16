package com.arnold7800.mobileappdevproject.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "driving_instruction_details")
data class DrivingLicenseInstructionApplication(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "instructor_id")
    val id: Int,

    @ColumnInfo(name = "driving_instructor_name")
    val drivingInstructorName: String,

    @ColumnInfo(name = "driving_instructor_ntsaNO")
    val drivingInstructorNtsaNo: Int,

    @ColumnInfo(name = "driving_school")
    val drivingSchool: String,

    @ColumnInfo(name = "driving_school_address")
    val drivingSchoolAddress: String,

    @ColumnInfo(name = "dl_category")
    val dlCategory: String
)
