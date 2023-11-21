package com.example.housingguru

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

class FragmentReg : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_reg, container, false)
        view.findViewById<TextView>(R.id.enter_tv).setOnClickListener{view.findNavController()
            .navigate(R.id.action_fragmentReg_to_fragmentAuth)}
        return view
    }
}