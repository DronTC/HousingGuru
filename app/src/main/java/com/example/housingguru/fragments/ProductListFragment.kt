package com.example.housingguru.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.navigation.findNavController
import com.example.housingguru.ListViewAdapter
import com.example.housingguru.R
import com.example.housingguru.model.Filter
import com.example.housingguru.model.House
import com.example.housingguru.model.ListHouses

class productListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_product_list, container, false)

        val listView = view.findViewById<ListView>(R.id.listView)

        var listFilterHouses = mutableListOf<House>()
        for(i in ListHouses.list){
            if(checkHouse(i))
                listFilterHouses.add(i)
        }

        listView.isClickable = true
        val adapter = ListViewAdapter(requireContext(), R.layout.list_item, listFilterHouses)
        listView.adapter = adapter


        return view
    }
    fun checkHouse(house: House) : Boolean{
        if(Filter.city != "")
            if(house.city != Filter.city)
                return false
        if(house.price < Filter.minPrice || house.price > Filter.maxPrice)
            return false
        if(house.rating < Filter.minRating)
            return false
        if(Filter.types.size == 0)
            return true
        for(i in Filter.types)
            if(house.type == i)
                return true
        return true
    }
}