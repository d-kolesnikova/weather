package com.example.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.data.DailyWeather
import com.example.weather.databinding.ItemDailyBinding
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.*


private fun convertDateToString(time: Date): String {
    val locale = Locale("ru")
    val dfs = DateFormatSymbols.getInstance(locale)
    dfs.shortWeekdays = arrayOf<String>("", "Bс", "Пн", "Вт", "Ср", "Чт", "Пт", "Сб")
    val formatDay = SimpleDateFormat("EE", locale)
    formatDay.dateFormatSymbols = dfs
    return formatDay.format(time)
}

class DailyAdapter(private val data: List<DailyWeather>) :
    RecyclerView.Adapter<DailyAdapter.DailyViewHolder>() {

    class DailyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemDailyBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_daily, parent, false)
        return DailyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        val item: DailyWeather = data.get(position)
        with(holder.binding) {
            tvDay.text = convertDateToString(item.date)
            tvTemp.text = item.temp.toString()
            ivWeather.setImageResource(item.drawableWeather)
            ivWeather.setColorFilter(R.color.black)
        }
    }

    override fun getItemCount() = data.size

}