package com.infinite.massiveprojectmobilezwh

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retro {
    fun getRetroCLientInstance(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("https://api.smart-recycling.my.id/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}