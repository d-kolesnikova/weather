package com.example.weather.data

import androidx.annotation.DrawableRes
import java.util.*

data class DailyWeather(
    var date: Date,
    var temp: Int,
    @DrawableRes
    var drawableWeather: Int,
)

