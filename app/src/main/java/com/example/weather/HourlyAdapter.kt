package com.example.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.data.HourlyWeather
import com.example.weather.databinding.ItemHourlyBinding

class HourlyAdapter(private val data: List<HourlyWeather>) :
    RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder>() {

    class HourlyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemHourlyBinding.bind(view)
    }

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {
        val item: HourlyWeather = data.get(position)
        with(holder.binding) {
            tvTime.text = item.time.toString()
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
