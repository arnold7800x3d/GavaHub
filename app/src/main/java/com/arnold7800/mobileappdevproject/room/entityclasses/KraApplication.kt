package com.arnold7800.mobileappdevproject.room.entityclasses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kra_applications_details")
data class KraApplication(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "applicant_id")
    val id: Int,

    @ColumnInfo(name = "applicant_residency")
    val residency: String,

    @ColumnInfo(name = "applicant_name")
    val name: String,

    @ColumnInfo(name = "applicant_email")
    val email: String,

    @ColumnInfo(name = "applicant_dob")
    val dob: String,

    @ColumnInfo(name = "applicant_idNo")
    val idNo: Int,

    @ColumnInfo(name = "applicant_sex")
    val sex: String,

    @ColumnInfo(name = "zip_code")
    val zipCode: Int,

    @ColumnInfo(name = "applicant_postal_address")
    val postalAddress: String,

    @ColumnInfo(name = "pin_type")
    val pinType: String
)
