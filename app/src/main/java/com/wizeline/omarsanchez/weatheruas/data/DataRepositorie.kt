package com.wizeline.omarsanchez.weatheruas.data

import com.wizeline.omarsanchez.weatheruas.data.models.Forecast
import com.wizeline.omarsanchez.weatheruas.data.webservices.RetrofitApi
import io.reactivex.Observable


class DataRepositorie() :OnDataProvided{

    override fun getForecast(city: String, units: String, days: Int): Observable<Forecast> {
        return RetrofitApi().getForecast(city, units, days)
    }
}