package com.arnold7800.mobileappdevproject.room.entityclasses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passport_parent_details")
data class PassportParentDetailsApplication(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id: Int,

    @ColumnInfo(name = "mother_name")
    val motherName: String,

    @ColumnInfo(name = "mother_idNo")
    val motherIdNo: String,

    @ColumnInfo(name = "mother_dob")
    val motherDob: String,

    @ColumnInfo(name = "mother_dod")
    val motherDod: String,

    @ColumnInfo(name = "father_name")
    val fatherName: String,

    @ColumnInfo(name = "father_idNo")
    val fatherIdNo: String,

    @ColumnInfo(name = "father_dob")
    val fatherDob: String,

    @ColumnInfo(name = "father_dod")
    val fatherDod: String,

    @ColumnInfo(name = "guardian_name")
    val guardianName: String,

    @ColumnInfo(name = "guardian_idNo")
    val guardianIdNo: String,

    @ColumnInfo(name = "guardian_dob")
    val guardianDob: String,

    @ColumnInfo(name = "guardian_dod")
    val guardianDod: String,

    @ColumnInfo(name = "guardian_relationship")
    val guardianRelationship: String
)
