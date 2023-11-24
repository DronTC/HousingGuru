package com.example.housingguru.fragments

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.housingguru.R
import com.example.housingguru.model.Filter
import com.example.housingguru.model.MyButton


class MainMenuFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_main_menu, container, false)

        val hotelBtn = MyButton(view.findViewById<Button>(R.id.hotel_btn))
        val apartmentBtn = MyButton(view.findViewById<Button>(R.id.apartment_btn))
        val villaBtn = MyButton(view.findViewById<Button>(R.id.villa_btn))
        val hostelBtn = MyButton(view.findViewById<Button>(R.id.hostel_btn))
        val motelBtn = MyButton(view.findViewById<Button>(R.id.motel_btn))

        clickHouseButton(hotelBtn, resources.getColor(R.color.blue))
        clickHouseButton(apartmentBtn, resources.getColor(R.color.green))
        clickHouseButton(villaBtn, resources.getColor(R.color.red))
        clickHouseButton(hostelBtn, resources.getColor(R.color.orange))
        clickHouseButton(motelBtn, resources.getColor(R.color.dark_blue))

        view.findViewById<TextView>(R.id.reset_tv).setOnClickListener {
            Filter.city == ""
            Filter.types.clear()
            Filter.minRating = 0.0
            Filter.minPrice = 0
            Filter.maxPrice = 100000

            view.findViewById<EditText>(R.id.enterCity_et).text.clear()
            view.findViewById<EditText>(R.id.minPrice_et).text.clear()
            view.findViewById<EditText>(R.id.maxPrice_et).text.clear()

        }

        view.findViewById<Button>(R.id.confirm_btn).setOnClickListener {
            Filter.city = view.findViewById<EditText>(R.id.enterCity_et).text.toString()
            if(view.findViewById<EditText>(R.id.minPrice_et).text.toString() == "")
                Filter.minPrice = 0
            else
                Filter.minPrice = view.findViewById<EditText>(R.id.minPrice_et).text.toString().toInt()
            if(view.findViewById<EditText>(R.id.maxPrice_et).text.toString() == "")
                Filter.maxPrice = 100000
            else
                Filter.maxPrice = view.findViewById<EditText>(R.id.maxPrice_et).text.toString().toInt()
            Filter.minRating = view.findViewById<RatingBar>(R.id.min_rating_rb).rating.toString().toDouble()

            hotelBtn.isActive = false
            apartmentBtn.isActive = false
            villaBtn.isActive = false
            hostelBtn.isActive = false
            motelBtn.isActive = false

            view.findNavController().navigate(R.id.action_mainMenuFragment_to_productListFragment)
        }

        return view
    }
    fun clickHouseButton(myButton: MyButton, color: Int){

        myButton.button.setOnClickListener {
            if(myButton.isActive){
                myButton.button.setBackgroundColor(resources.getColor(R.color.gray))
                Filter.types.remove(myButton.button.text.toString())
                myButton.isActive = false
            }
            else{
                myButton.button.setBackgroundColor(color)
                Filter.types.add(myButton.button.text.toString())
                myButton.isActive = true
            }
        }
    }

}