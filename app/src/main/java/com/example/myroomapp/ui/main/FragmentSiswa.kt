package com.example.myroomapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myroomapp.R

class FragmentSiswa: Fragment() {

    private lateinit var nameText: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.detail_siswa, container, false)

        nameText = view.findViewById<View>(R.id.fragmentName) as TextView

        val bundle = arguments
        val message = bundle!!.getString("mText")

        nameText.text = message


        return super.onCreateView(inflater, container, savedInstanceState)
    }
}