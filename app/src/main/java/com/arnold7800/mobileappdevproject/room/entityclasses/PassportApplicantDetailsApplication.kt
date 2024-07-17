package com.arnold7800.mobileappdevproject.room.entityclasses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "passport_applicant_details")
data class PassportApplicantDetailsApplication(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "applicant_id")
    val id: Int,

    @ColumnInfo(name = "applicant_name")
    val name: String,

    @ColumnInfo(name = "applicant_dob")
    val dob: String,

    @ColumnInfo(name = "applicant_sex")
    val sex: String,

    @ColumnInfo(name = "applicant_pob")
    val pob: String,

    @ColumnInfo(name = "applicant_phone_number")
    val phoneNo: Int,

    @ColumnInfo(name = "zip_code")
    val zipCode: Int
)
