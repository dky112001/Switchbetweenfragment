package com.example.switchbetweenfragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class HomeFragment : Fragment() {
       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)
           val btnSwitchToProfile = view.findViewById<Button>(R.id.btnSwitchToProfile)

           val etMessage = view.findViewById<EditText>(R.id.etMessage)
           val btnSend = view.findViewById<Button>(R.id.btnSend)



           val etName = view.findViewById<EditText>(R.id.etName)
           val etEmail = view.findViewById<EditText>(R.id.etEmail)
           val etMobile = view.findViewById<EditText>(R.id.etMobile)
           val btnSendData = view.findViewById<Button>(R.id.btnSendData)

           btnSendData.setOnClickListener {
               val name = etName.text.toString()
               val email = etEmail.text.toString()
               val mobile = etMobile.text.toString()

               // SharedPreferences ka istemal karke data ko store karein
               saveData(name, email, mobile)

               // ProfileFragment ko bhejen
               val profileFragment = ProfileFragment()

               // Switch to ProfileFragment
               fragmentcall(profileFragment)
           }





           btnSendData.setOnClickListener {
               val name = etName.text.toString()
               val email = etEmail.text.toString()
               val mobile = etMobile.text.toString()

               // SharedPreferences ka istemal karke data ko store karein
               saveData(name, email, mobile)

               // ProfileFragment ko bhejen
               val profileFragment = ProfileFragment()

               // Switch to ProfileFragment
               fragmentcall(profileFragment)
           }







           btnSendData.setOnClickListener {
               val name = etName.text.toString()
               val email = etEmail.text.toString()
               val mobile = etMobile.text.toString()

               // SharedPreferences ka istemal karke data ko store karein
               saveData(name, email, mobile)

               // ProfileFragment ko bhejen
               val profileFragment = ProfileFragment()
               fragmentcall(profileFragment)
           }




           btnSend.setOnClickListener {
               val message = etMessage.text.toString()

               // Bundle bana kar text data ko set karein
               val bundle = Bundle()
               bundle.putString("message", message)

               // ProfileFragment ko bhejen
               val profileFragment = ProfileFragment()
               profileFragment.arguments = bundle

               // Switch to ProfileFragment
               fragmentcall(profileFragment)
           }



           btnSwitchToProfile.setOnClickListener {
               fragmentcall(ProfileFragment())
           }




           return view
    }

    private fun fragmentcall(fragment: Fragment) {
        val activity = requireActivity()
        if (activity is MainActivity){
            activity.fragmentcall(fragment)
        }
    }

    private fun saveData(name: String, email: String, mobile: String) {
        val sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("name", name)
        editor.putString("email", email)
        editor.putString("mobile", mobile)

        editor.apply()
    }

}