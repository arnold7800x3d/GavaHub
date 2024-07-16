package com.arnold7800.mobileappdevproject.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PassportApplication::class, NationalIDApplication::class, KraApplication::class, DrivingLicenseApplication::class, BusinessNameRegistrationApplication::class, BusinessRegistrationApplication::class,  DrivingLicenseInstructionApplication::class], version = 3, exportSchema = false)
abstract class ApplicantDetailsDatabase : RoomDatabase(){

    abstract fun passportApplicationDAO(): PassportDAO
    abstract fun nationalIDApplicationDAO(): NationalIDDAO
    abstract fun kraApplicationDAO(): KraDAO
    abstract fun drivingLicenseApplicationDAO(): DrivingLicenseDAO
    abstract fun drivingLicenseInstructionDAO(): DrivingLicenseInstructionDAO
    abstract fun businessNameRegistrationApplicationDAO(): BusinessNameRegistrationDAO
    abstract fun businessRegistrationApplicationDAO(): BusinessRegistrationDAO

    //Singleton
    companion object{
        @Volatile
        private var Instance: ApplicantDetailsDatabase ?= null
            fun getDatabase(context: Context): ApplicantDetailsDatabase{
                //if db is null, return it or otherwise create a new database instance
                return Instance ?: synchronized(this) {
                    Room.databaseBuilder(context, ApplicantDetailsDatabase::class.java, "gavaHub_database" )
                        .fallbackToDestructiveMigration()
                        .build()
                        .also {
                            Instance = it
                        }
                }
            }
    }
}