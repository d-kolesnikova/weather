package com.example.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.data.CurrentWeather
import com.example.weather.data.DailyWeather
import com.example.weather.data.HourlyWeather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class WeatherViewModel : ViewModel() {
    private var _currentWeather = CurrentWeather(
        date = Date(Calendar.getInstance().timeInMillis),
        tempMin = 12,
        tempMax = 30,
        windDirection = R.drawable.ic_icon_wind_e,
        windSpeed = 5,
        drawableWeather = R.drawable.ic_white_day_cloudy,
        humidity = 33,
    )
    val currentWeather get() = _currentWeather

    private var _hourlyWeather: List<HourlyWeather> = emptyList()
    val hourlyWeather get() = _hourlyWeather

    private var _dailyWeather: List<DailyWeather> = emptyList()
    val dailyWeather get() = _dailyWeather

    fun loadHourlyForecast(onLoaded: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(3000)
            _hourlyWeather = listOf(
                HourlyWeather(
                    time = Date(Calendar.getInstance().timeInMillis),
                    temp = 12,
                    drawableWeather = R.drawable.ic_white_day_cloudy,
                ),
                HourlyWeather(
                    time = Date(Calendar.getInstance().timeInMillis),
                    temp = 12,
                    drawableWeather = R.drawable.ic_white_day_cloudy,
                ),
                HourlyWeather(
                    time = Date(Calendar.getInstance().timeInMillis),
                    temp = 12,
                    drawableWeather = R.drawable.ic_white_day_cloudy,
                ),
                HourlyWeather(
                    time = Date(Calendar.getInstance().timeInMillis),
                    temp = 12,
                    drawableWeather = R.drawable.ic_white_day_cloudy,
                ),
                HourlyWeather(
                    time = Date(Calendar.getInstance().timeInMillis),
                    temp = 12,
                    drawableWeather = R.drawable.ic_white_day_cloudy,
                ),
                HourlyWeather(
                    time = Date(Calendar.getInstance().timeInMillis),
                    temp = 12,
                    drawableWeather = R.drawable.ic_white_day_cloudy,
                ),
                HourlyWeather(
                    time = Date(Calendar.getInstance().timeInMillis),
                    temp = 12,
                    drawableWeather = R.drawable.ic_white_day_cloudy,
                ),
                HourlyWeather(
                    time = Date(Calendar.getInstance().timeInMillis),
                    temp = 12,
                    drawableWeather = R.drawable.ic_white_day_cloudy,
                ),
                HourlyWeather(
                    time = Date(Calendar.getInstance().timeInMillis),
                    temp = 12,
                    drawableWeather = R.drawable.ic_white_day_cloudy,
                ),
            )
            viewModelScope.launch(Dispatchers.Main) {
                onLoaded.invoke()
            }

        }

    }

    fun loadDailyForecast(onLoaded: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            _dailyWeather = listOf(
                DailyWeather(
                    date = Date(Calendar.getInstance().timeInMillis),
                    temp = 12,
                    drawableWeather = R.drawable.ic_white_day_cloudy,
                ),
                DailyWeather(
                    date = Date(Calendar.getInstance().timeInMillis),
                    temp = 12,
                    drawableWeather = R.drawable.ic_white_day_cloudy,
                ),
                DailyWeather(
                    date = Date(Calendar.getInstance().timeInMillis),
                    temp = 12,
                    drawableWeather = R.drawable.ic_white_day_cloudy,
                )
            )
            viewModelScope.launch(Dispatchers.Main) {
                onLoaded.invoke()
            }
        }
    }
}
