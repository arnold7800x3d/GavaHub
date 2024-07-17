package com.arnold7800.mobileappdevproject.room.entityclasses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "business_registration_details")
data class BusinessRegistrationApplication(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "owners_id")
    val ownersID: Int,

    @ColumnInfo(name = "owner_A")
    val ownerA: String,

    @ColumnInfo(name = "owner_A_idNo")
    val ownerAIdNo: String,

    @ColumnInfo(name = "owner_B")
    val ownerB: String,

    @ColumnInfo(name = "owner_B_idNo")
    val ownerBIdNo: String,

    @ColumnInfo(name = "owner_C")
    val ownerC: String,

    @ColumnInfo(name = "owner_C_idNo")
    val ownerCIdNo: String,

    @ColumnInfo(name = "owner_D")
    val ownerD: String,

    @ColumnInfo(name = "owner_D_idNo")
    val ownerDIdNo: String,

    @ColumnInfo(name = "business_name")
    val businessName: String
)
