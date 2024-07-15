package com.arnold7800.mobileappdevproject.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DrivingLicenseApplications")
data class DrivingLicenseApplication(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "applicant_id")
    val id: Int,

    @ColumnInfo(name = "application_type")
    val applicationType: String,

    @ColumnInfo(name = "applicant_name")
    val name: String,

    @ColumnInfo(name = "applicant_phone_number")
    val phoneNumber: Number,

    @ColumnInfo(name = "applicant_email")
    val email:String,

    @ColumnInfo(name = "applicant_dob")
    val dob: Number,

    @ColumnInfo(name = "applicant_idNo")
    val idNo: Number,

    @ColumnInfo(name = "applicant_sex")
    val sex: String,

    @ColumnInfo(name = "zipcode")
    val zipCode: Number,

    @ColumnInfo(name = "applicant_postal_address")
    val applicantPostalAddress: String,

    @ColumnInfo(name = "driving_instructor_name")
    val drivingInstructorName: String,

    @ColumnInfo(name = "driving_instructor_ntsaNO")
    val drivingInstructorNtsaNo: Number,

    @ColumnInfo(name = "driving_school")
    val drivingSchool: String,

    @ColumnInfo(name = "driving_school_address")
    val drivingSchoolAddress: String,

    @ColumnInfo(name = "dl_category")
    val dlCategory: String

)
