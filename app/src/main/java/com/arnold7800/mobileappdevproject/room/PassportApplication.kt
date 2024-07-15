package com.arnold7800.mobileappdevproject.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "PassportApplications")
data class PassportApplication(
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

    @ColumnInfo(name = "zip_code")
    val zipCode: Number,

    @ColumnInfo(name = "mother_name")
    val motherName: String,

    @ColumnInfo(name = "mother_idNo")
    val motherIdNo: String,

    @ColumnInfo(name = "mother_dob")
    val motherDob: Number,

    @ColumnInfo(name = "mother_dod")
    val motherDod: Number,

    @ColumnInfo(name = "father_name")
    val fatherName: String,

    @ColumnInfo(name = "father_idNo")
    val fatherIdNo: String,

    @ColumnInfo(name = "father_dob")
    val fatherDob: Number,

    @ColumnInfo(name = "father_dod")
    val fatherDod: Number,

    @ColumnInfo(name = "guardian_name")
    val guardianName: String,

    @ColumnInfo(name = "guardian_idNo")
    val guardianIdNo: String,

    @ColumnInfo(name = "guardian_dob")
    val guardianDob: Number,

    @ColumnInfo(name = "guardian_dod")
    val guardianDod: Number,

    @ColumnInfo(name = "guardian_relationship")
    val guardianRelationship: String,

    @ColumnInfo(name = "recommender_name")
    val recommenderName: String,

    @ColumnInfo(name = "recommender_dob")
    val recommenderDob: Number,

    @ColumnInfo(name = "recommender_phone_no")
    val recommenderPhoneNo: Number,

    @ColumnInfo(name = "recommender_sex")
    val recommenderSex: String,

    @ColumnInfo(name = "recommender_idNo")
    val recommenderIDNo: Number,

    @ColumnInfo(name = "next_of_kin_name")
    val nextOfKinName: String,

    @ColumnInfo(name = "next_of_kin_idNo")
    val nextOfKinIdNo: Number,

    @ColumnInfo(name = "next_of_kin_dob")
    val nextOfKinDob: Number,

    @ColumnInfo(name = "next_of_kin_sex")
    val nextOfKinSex: String,

    @ColumnInfo(name = "next_of_kin_phone_no")
    val nextOfKinPhoneNo: Number,

    @ColumnInfo(name = "next_of_kin_relationship")
    val nextOfKinRelationship: String






)
