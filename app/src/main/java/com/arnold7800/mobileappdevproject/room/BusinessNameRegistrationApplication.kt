package com.arnold7800.mobileappdevproject.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BusinessNameRegistrationApplications")
data class BusinessNameRegistrationApplication(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "owners_id")
    val ownersID: Int,

    @ColumnInfo(name = "owner_A")
    val ownerA: String,

    @ColumnInfo(name = "owner_A_IdNo")
    val ownerAIdNo: Int,

    @ColumnInfo(name = "owner_B")
    val ownerB: String,

    @ColumnInfo(name = "owner_B_IdNo")
    val ownerBIdNo: String,

    @ColumnInfo(name = "owner_C")
    val ownerC: String,

    @ColumnInfo(name = "owner_CIdNo")
    val ownerCIdNo: String,

    @ColumnInfo(name = "owner_D")
    val ownerD: String,

    @ColumnInfo(name = "owner_DIdNo")
    val ownerDIdNo: String,

    @ColumnInfo(name = "business_name")
    val businessName: String,

    @ColumnInfo(name = "business_address")
    val businessAddress: String,

    @ColumnInfo(name = "zipcode")
    val zipCode: Int
)
