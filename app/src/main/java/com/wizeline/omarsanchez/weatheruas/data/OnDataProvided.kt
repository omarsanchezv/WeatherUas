package com.wizeline.omarsanchez.weatheruas.data

import com.wizeline.omarsanchez.weatheruas.data.models.Forecast
import io.reactivex.Observable

interface OnDataProvided {
    fun getForecast(city: String, units: String, days: Int):Observable<Forecast>
}