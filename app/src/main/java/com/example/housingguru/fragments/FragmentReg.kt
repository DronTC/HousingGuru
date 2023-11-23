package com.example.housingguru.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.housingguru.R
import com.example.housingguru.model.User
import com.example.housingguru.dataBase.Db

class FragmentReg : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_reg, container, false)
        view.findViewById<TextView>(R.id.enter_tv).setOnClickListener{view.findNavController()
            .navigate(R.id.action_fragmentReg_to_fragmentAuth)}

        view.findViewById<Button>(R.id.reg_btn).setOnClickListener {
            val login = view.findViewById<EditText>(R.id.et_login).text.toString().trim()
            val password = view.findViewById<EditText>(R.id.et_password).text.toString().trim()

            if(login == "" || password == "")
                Toast.makeText(requireContext(), "Заполнены не все поля", Toast.LENGTH_LONG).show()
            else{
                val user = User(login, password)

                val db = Db(requireContext(), null)
                db.addUser(user)
                Toast.makeText(requireContext(), "Пользователь $login зарегистрирован", Toast.LENGTH_SHORT).show()

                view.findViewById<EditText>(R.id.et_login).text.clear()
                view.findViewById<EditText>(R.id.et_password).text.clear()
            }
        }
        return view
    }
}