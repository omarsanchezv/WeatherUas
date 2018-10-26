package com.wizeline.omarsanchez.weatheruas.data.models


data class Day(
        val dt : Int,
        val temp: Temp,
        val weather: List<Weather>
){
    fun getDate(): String {
        return dt.toString()
    }

    fun getWeatherDescription(): String {
        return weather[0].description
    }

    fun getWeatherIcon() : String{
        return weather[0].icon
    }
}
