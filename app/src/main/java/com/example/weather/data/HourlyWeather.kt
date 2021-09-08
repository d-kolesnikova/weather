package com.example.weather.data

import androidx.annotation.DrawableRes
import java.util.*

data class HourlyWeather(
    var time: Date,
    @DrawableRes
    var drawableWeather: Int,
    var temp: Int,
)

