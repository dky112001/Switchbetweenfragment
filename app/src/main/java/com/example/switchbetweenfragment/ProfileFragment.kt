package com.example.switchbetweenfragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class ProfileFragment : Fragment() {


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val tvReceivedMessage = view.findViewById<TextView>(R.id.tvReceivedMessage)


        // SharedPreferences se data retrieve karein
        val sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "")
        val email = sharedPreferences.getString("email", "")
        val mobile = sharedPreferences.getString("mobile", "")

        // XML mein banaye gaye TextViews ka reference lekar unko update karein
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvEmail = view.findViewById<TextView>(R.id.tvEmail)
        val tvMobile = view.findViewById<TextView>(R.id.tvMobile)

        tvName.text = "Name: $name"
        tvEmail.text = "Email: $email"
        tvMobile.text = "Mobile: $mobile"


        // Arguments se text data extract karein
        val message = arguments?.getString("message")

        tvReceivedMessage.text = "Received Message: $message"


        return  view
    }



}