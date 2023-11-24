package com.example.housingguru

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import de.hdodenhof.circleimageview.CircleImageView

class product_page_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_page)

        findViewById<ImageView>(R.id.house_image).setImageResource(intent.getIntExtra("imageId", R.drawable.charming_image))
        findViewById<TextView>(R.id.name_tv).text = intent.getStringExtra("name")
        findViewById<TextView>(R.id.city_tv).text = intent.getStringExtra("city")
        findViewById<TextView>(R.id.type_tv).text = intent.getStringExtra("type")
        findViewById<TextView>(R.id.price_tv).text = intent.getStringExtra("price")
        findViewById<TextView>(R.id.rating_tv).text = intent.getStringExtra("rating")
        findViewById<TextView>(R.id.description_tv).text = intent.getStringExtra("description")

        findViewById<Button>(R.id.booking_btn).setOnClickListener {
            Toast.makeText(this, "Номер забронирован", Toast.LENGTH_SHORT).show()
        }

    }
}