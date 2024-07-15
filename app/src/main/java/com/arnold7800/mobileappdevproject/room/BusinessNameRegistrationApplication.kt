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
    val owenerA: String,

    @ColumnInfo(name = "owner_B")
    val owenerB: String,

    @ColumnInfo(name = "owner_C")
    val owenerC: String,

    @ColumnInfo(name = "owner_D")
    val owenerD: String,

    @ColumnInfo(name = "business_name")
    val businessName: String,

    @ColumnInfo(name = "business_address")
    val businessAddress: String,

    @ColumnInfo(name = "zipcode")
    val zipCode: Number
)
