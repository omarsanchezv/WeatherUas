package com.wizeline.omarsanchez.weatheruas.data.models

data class Forecast(
        val city: City,
        val cod: String,
        val count: Int,
        val list: List<Day>
)