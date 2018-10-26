package com.wizeline.omarsanchez.weatheruas.data.webservices

import com.wizeline.omarsanchez.weatheruas.data.models.Forecast
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

internal interface Services {
    @GET("daily")
    fun getForecast(@Query("q")place:String, @Query("units")unit: String, @Query("cnt")days:Int, @Query("appid")apiKey:String):Observable<Forecast>

}