package com.arnold7800.mobileappdevproject.room.gavahubdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arnold7800.mobileappdevproject.room.entityclasses.BusinessNameRegistrationApplication
import com.arnold7800.mobileappdevproject.room.daoclasses.BusinessNameRegistrationDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.BusinessRegistrationApplication
import com.arnold7800.mobileappdevproject.room.daoclasses.BusinessRegistrationDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.DrivingLicenseApplication
import com.arnold7800.mobileappdevproject.room.daoclasses.DrivingLicenseDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.DrivingLicenseInstructionApplication
import com.arnold7800.mobileappdevproject.room.daoclasses.DrivingLicenseInstructionDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.KraApplication
import com.arnold7800.mobileappdevproject.room.daoclasses.KraDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.NationalIDApplication
import com.arnold7800.mobileappdevproject.room.entityclasses.NationalIDApplicationParentDetails
import com.arnold7800.mobileappdevproject.room.daoclasses.NationalIDApplicationParentDetailsDAO
import com.arnold7800.mobileappdevproject.room.daoclasses.NationalIDDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportApplicantDetailsApplication
import com.arnold7800.mobileappdevproject.room.daoclasses.PassportApplicantDetailsDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportNextOfKinDetailsApplication
import com.arnold7800.mobileappdevproject.room.daoclasses.PassportNextOfKinDetailsDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportParentDetailsApplication
import com.arnold7800.mobileappdevproject.room.daoclasses.PassportParentDetailsDAO
import com.arnold7800.mobileappdevproject.room.entityclasses.PassportRecommenderDetailsApplication
import com.arnold7800.mobileappdevproject.room.daoclasses.PassportRecommenderDetailsDAO

@Database(entities = [PassportApplicantDetailsApplication::class, NationalIDApplication::class, KraApplication::class, DrivingLicenseApplication::class, BusinessNameRegistrationApplication::class, BusinessRegistrationApplication::class,  DrivingLicenseInstructionApplication::class, NationalIDApplicationParentDetails::class, PassportParentDetailsApplication::class, PassportRecommenderDetailsApplication::class, PassportNextOfKinDetailsApplication::class], version = 6, exportSchema = false)
abstract class ApplicantDetailsDatabase : RoomDatabase(){

    abstract fun passportApplicantDetailsDAO(): PassportApplicantDetailsDAO
    abstract fun passportParentDetailsDAO(): PassportParentDetailsDAO
    abstract fun passportRecommenderDetailsDAO(): PassportRecommenderDetailsDAO
    abstract fun passportNextOfKinDetailsDAO(): PassportNextOfKinDetailsDAO
    abstract fun nationalIDApplicationDAO(): NationalIDDAO
    abstract fun nationalIDParentDetailsDAO(): NationalIDApplicationParentDetailsDAO
    abstract fun kraApplicationDAO(): KraDAO
    abstract fun drivingLicenseApplicationDAO(): DrivingLicenseDAO
    abstract fun drivingLicenseInstructionDAO(): DrivingLicenseInstructionDAO
    abstract fun businessNameRegistrationApplicationDAO(): BusinessNameRegistrationDAO
    abstract fun businessRegistrationApplicationDAO(): BusinessRegistrationDAO

    //Singleton
    companion object{
        @Volatile
        private var Instance: ApplicantDetailsDatabase?= null
            fun getDatabase(context: Context): ApplicantDetailsDatabase {
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