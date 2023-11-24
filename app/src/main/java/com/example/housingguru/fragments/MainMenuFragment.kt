package com.example.housingguru.fragments

import android.R.attr
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.housingguru.R


class MainMenuFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_main_menu, container, false)
        clickButton(view.findViewById<Button>(R.id.hotel_btn), resources.getColor(R.color.blue))

        return view
    }
    fun clickButton(button: Button, color: Int){
        val color = button.background.colorFilter

        button.setOnClickListener {
            Toast.makeText(requireContext(), "${color}", Toast.LENGTH_SHORT).show()
        }
    }
}