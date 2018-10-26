package com.wizeline.omarsanchez.weatheruas.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.wizeline.omarsanchez.weatheruas.R
import com.wizeline.omarsanchez.weatheruas.data.models.Day
import com.wizeline.omarsanchez.weatheruas.extentions.UTCtoGMT

class ForecastAdapter(var items: List<Day>) : RecyclerView.Adapter<ForecastAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): Holder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return Holder(itemView)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size


    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var date: TextView = itemView.findViewById(R.id.textView)
        var tempMin: TextView = itemView.findViewById(R.id.textView4)
        var tempMax: TextView = itemView.findViewById(R.id.textView5)
        var description: TextView = itemView.findViewById(R.id.textView6)
        var icon: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(day: Day) {
            date.text = day.getDate().UTCtoGMT()
            tempMin.text = day.temp.min
            tempMax.text = day.temp.max
            description.text = day.getWeatherDescription()
            Glide.with(icon.context).load(icon.context.getString(R.string.image_url, day.getWeatherIcon())).into(icon)
        }

    }
}