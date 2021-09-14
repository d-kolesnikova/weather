package com.example.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.data.HourlyWeather
import com.example.weather.databinding.ItemHourlyBinding
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.*

private fun convertDateToStringH(time: Date): String {
    val locale = Locale("ru")
    val dfs = DateFormatSymbols.getInstance(locale)
    val formatTime = SimpleDateFormat("kk:mm", locale)
    formatTime.dateFormatSymbols = dfs
    return formatTime.format(time)
}

class HourlyAdapter(private val data: List<HourlyWeather>) :
    RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder>() {

    class HourlyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemHourlyBinding.bind(view)
    }

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {
        val item: HourlyWeather = data.get(position)
        with(holder.binding) {
            tvTime.text = convertDateToStringH(item.time)
            ivHourlyWeather.setImageResource(item.drawableWeather)
            tvHourlyTemp.text = item.temp.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_hourly, parent, false)
        return HourlyViewHolder(itemView)
    }

    override fun getItemCount() = data.size


}
