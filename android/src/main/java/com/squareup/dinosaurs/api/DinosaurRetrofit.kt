package com.squareup.dinosaurs.api

import retrofit2.Retrofit
import retrofit2.converter.wire.WireConverterFactory

object DinosaurRetrofit {
  val dinosaursApi: DinosaursApi = Retrofit.Builder()
    .baseUrl("http://10.0.2.2:8080") // If you run on emulator, use this, if not, point to your own IP address
    .addConverterFactory(WireConverterFactory.create())
    .build()
    .create(DinosaursApi::class.java)
}
