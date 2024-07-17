package com.arnold7800.mobileappdevproject.room.entityclasses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "driving_license_applications")
data class DrivingLicenseApplication(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "applicant_id")
    val id: Int,

    @ColumnInfo(name = "application_type")
    val applicationType: String,

    @ColumnInfo(name = "applicant_name")
    val name: String,

    @ColumnInfo(name = "applicant_phone_number")
    val phoneNumber: String,

    @ColumnInfo(name = "applicant_email")
    val email:String,

    @ColumnInfo(name = "applicant_dob")
    val dob: String,

    @ColumnInfo(name = "applicant_idNo")
    val idNo: String,

    @ColumnInfo(name = "applicant_sex")
    val sex: String,

    @ColumnInfo(name = "zipcode")
    val zipCode: String,

    @ColumnInfo(name = "applicant_postal_address")
    val applicantPostalAddress: String,
)
