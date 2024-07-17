package com.arnold7800.mobileappdevproject.room.entityclasses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passport_recommender_details")
data class PassportRecommenderDetailsApplication(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id: Int,

    @ColumnInfo(name = "recommender_name")
    val recommenderName: String,

    @ColumnInfo(name = "recommender_dob")
    val recommenderDob: String,

    @ColumnInfo(name = "recommender_phone_no")
    val recommenderPhoneNo: String,

    @ColumnInfo(name = "recommender_sex")
    val recommenderSex: String,

    @ColumnInfo(name = "recommender_idNo")
    val recommenderIDNo: String
)
