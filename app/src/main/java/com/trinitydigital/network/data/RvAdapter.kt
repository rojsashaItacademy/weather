package com.trinitydigital.network.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trinitydigital.network.R
import com.trinitydigital.network.data.model.forecast.ForecastItem
import kotlinx.android.synthetic.main.item_forecast.view.*

class RvAdapter : RecyclerView.Adapter<RvHolder>() {

    val list = arrayListOf<ForecastItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_forecast, parent, false)

        return RvHolder(view)
    }

    fun update(list: List<ForecastItem>?) {
        if (list != null) {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }

    }

    override fun onBindViewHolder(holder: RvHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}


class RvHolder(v: View) : RecyclerView.ViewHolder(v) {

    fun bind(forecastItem: ForecastItem) {
        itemView.tvTitle.text = forecastItem.main.temp.toString()
    }

}