package com.example.housingguru

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

import com.example.housingguru.model.House


class ListViewAdapter (context: Context, private val layoutResourceId: Int, private val data: List<House>) :
ArrayAdapter<House>(context, layoutResourceId, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var row = convertView
        val holder: ViewHolder

        if (row == null) {
            val inflater = LayoutInflater.from(context)
            row = inflater.inflate(layoutResourceId, parent, false)

            holder = ViewHolder()
            holder.imageImageView = row.findViewById(R.id.house_image)
            holder.nameTextView = row.findViewById(R.id.house_name_tv)
            holder.cityTextView = row.findViewById(R.id.house_city_tv)
            holder.priceTextView = row.findViewById(R.id.house_price_tv)
            holder.ratingTextView = row.findViewById(R.id.house_rating)
            holder.houseTypeTextView = row.findViewById(R.id.house_type_tv)


            row.tag = holder
        } else {
            holder = row.tag as ViewHolder
        }

        val item = data[position]
        holder.imageImageView?.setImageResource(item.imageId)
        holder.nameTextView?.text = item.name
        holder.cityTextView?.text = item.city
        holder.priceTextView?.text = item.price.toString()
        holder.ratingTextView?.text = item.rating.toString()
        holder.houseTypeTextView?.text = item.type

        row?.setOnClickListener {
            val intent = Intent(context, product_page_activity::class.java)
            intent.putExtra("imageId", item.imageId)
            intent.putExtra("name", item.name)
            intent.putExtra("city", item.city)
            intent.putExtra("type", item.type)
            intent.putExtra("price", item.price)
            intent.putExtra("rating", item.rating)
            intent.putExtra("description", item.description)
            context.startActivity(intent)
        }

        return row!!
    }

    private class ViewHolder {
        var imageImageView: ImageView? = null
        var nameTextView: TextView? = null
        var cityTextView: TextView? = null
        var priceTextView: TextView? = null
        var ratingTextView: TextView? = null
        var houseTypeTextView: TextView? = null
    }
}