package com.arnold7800.mobileappdevproject.api

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface DarajaAPIServer {
    @GET("lipa/{amount}/{phone}/{type}")
    suspend fun initiatePayment(
        @Path("amount") amount: Int,
        @Path("phone") phone: String,
        @Path("type") type: String,
    ): String
}

object NetworkModule {
    val darajaApi: DarajaAPIServer by lazy {
        Retrofit.Builder()
            .baseUrl("https://f7b1-105-161-136-145.ngrok-free.app")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
            .create(DarajaAPIServer::class.java)
    }
}