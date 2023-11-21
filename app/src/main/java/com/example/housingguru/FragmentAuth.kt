package com.example.housingguru

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

class FragmentAuth : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_auth, container, false)
        view.findViewById<TextView>(R.id.reg_tv).setOnClickListener{view.findNavController()
            .navigate(R.id.action_fragmentReg_to_fragmentReg)}
        return view
    }
}