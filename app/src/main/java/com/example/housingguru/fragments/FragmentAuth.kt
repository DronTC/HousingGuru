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

class FragmentAuth : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_auth, container, false)
        view.findViewById<TextView>(R.id.reg_tv).setOnClickListener{view.findNavController()
            .navigate(R.id.action_fragmentReg_to_fragmentReg)}

        view.findViewById<Button>(R.id.auth_btn).setOnClickListener {
            val login = view.findViewById<EditText>(R.id.et_login).text.toString().trim()
            val password = view.findViewById<EditText>(R.id.et_password).text.toString().trim()

            if(login == "" || password == "")
                Toast.makeText(requireContext(), "Заполнены не все поля", Toast.LENGTH_LONG).show()
            else{
                val db = Db(requireContext(), null)
                if(db.checkUser(login, password)){
                    Toast.makeText(requireContext(), "Пользователь $login авторизован",
                        Toast.LENGTH_SHORT).show()
                }
                else
                    Toast.makeText(requireContext(), "Неверный логин или пароль",
                        Toast.LENGTH_LONG).show()
            }
            view.findViewById<EditText>(R.id.et_login).text.clear()
            view.findViewById<EditText>(R.id.et_password).text.clear()
        }

        return view
    }
}