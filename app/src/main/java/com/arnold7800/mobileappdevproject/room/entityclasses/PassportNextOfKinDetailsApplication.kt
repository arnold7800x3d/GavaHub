package com.arnold7800.mobileappdevproject.room.entityclasses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passport_next_of_kin_details")
data class PassportNextOfKinDetailsApplication(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id: Int,

    @ColumnInfo(name = "next_of_kin_name")
    val nextOfKinName: String,

    @ColumnInfo(name = "next_of_kin_idNo")
    val nextOfKinIdNo: String,

    @ColumnInfo(name = "next_of_kin_dob")
    val nextOfKinDob: String,

    @ColumnInfo(name = "next_of_kin_sex")
    val nextOfKinSex: String,

    @ColumnInfo(name = "next_of_kin_phone_no")
    val nextOfKinPhoneNo: String,

    @ColumnInfo(name = "next_of_kin_relationship")
    val nextOfKinRelationship: String
)
