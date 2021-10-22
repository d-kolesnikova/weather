package com.example.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weather.databinding.FragmentWeatherBinding
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.*

class WeatherFragment : Fragment() {
    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WeatherViewModel by viewModels()

    private val hourlyAdapter = HourlyAdapter(emptyList())
    private val dailyAdapter = DailyAdapter(emptyList())

    private fun convertDateToString(time: Date): String {
        val locale = Locale("ru")
        val dfs = DateFormatSymbols.getInstance(locale)
        dfs.shortWeekdays = arrayOf<String>("", "Bс", "Пн", "Вт", "Ср", "Чт", "Пт", "Сб")
        val format = SimpleDateFormat("E, d MMMM", locale)
        format.dateFormatSymbols = dfs
        return format.format(time)
    }

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

        with(binding) {
            tvDate.text = convertDateToString(viewModel.currentWeather.date)
            tvTemp.text = viewModel.currentWeather.tempMin.toString().plus("/")
                .plus(viewModel.currentWeather.tempMax)
            tvHumidity.text = viewModel.currentWeather.humidity.toString()
            tvWind.text = viewModel.currentWeather.windSpeed.toString()
            ivWindDirection.setImageResource(viewModel.currentWeather.windDirection)
            ivMainWeather.setImageResource(viewModel.currentWeather.drawableWeather)

            rvHourlyWeather.adapter = hourlyAdapter
            rvDailyWeather.adapter = dailyAdapter

            pbDaily.isVisible = true
            pbHourly.isVisible = true
        }
        viewModel.loadHourlyForecast(::onHourlyLoaded)
        viewModel.loadDailyForecast(::onDailyLoaded)
    }


    private fun onHourlyLoaded() {
        hourlyAdapter.setData(viewModel.hourlyWeather)
        binding.rvHourlyWeather.isVisible = true
        binding.pbHourly.isVisible = false
    }

    private fun onDailyLoaded() {
        dailyAdapter.setData(viewModel.dailyWeather)
        binding.rvDailyWeather.isVisible = true
        binding.pbDaily.isVisible = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}