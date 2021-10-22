package com.example.weather.data

import androidx.annotation.DrawableRes
import java.util.*


data class CurrentWeather(
    var date: Date,
    var tempMin: Int,
    var tempMax: Int,
    var humidity: Int,
    var windSpeed: Int,
    @DrawableRes
    var windDirection: Int,
    @DrawableRes
    var drawableWeather: Int,
)
