package com.example.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weather.data.CurrentWeather
import com.example.weather.databinding.FragmentWeatherBinding
import java.util.*

class WeatherFragment : Fragment() {
    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentWeather = CurrentWeather(
            date = Date(Calendar.getInstance().timeInMillis),
            tempMin = 12,
            tempMax = 30,
            windDirection = R.drawable.ic_icon_wind_e,
            windSpeed = 5,
            drawableWeather = R.drawable.ic_white_day_cloudy,
            humidity = 33,
        )
        with(binding) {
            tvDate.text = currentWeather.date.toString()
            tvTemp.text = currentWeather.tempMin.toString().plus("/").plus(currentWeather.tempMax)
            tvHumidity.text = currentWeather.humidity.toString()
            tvWind.text = currentWeather.windSpeed.toString()
            ivWindDirection.setImageResource(currentWeather.windDirection)
            ivMainWeather.setImageResource(currentWeather.drawableWeather)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}