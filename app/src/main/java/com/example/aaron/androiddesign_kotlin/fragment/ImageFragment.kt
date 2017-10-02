package com.example.aaron.androiddesign_kotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.aaron.androiddesign_kotlin.R

class ImageFragment : Fragment() {
    var fragVal: Int = 0
    var fragImage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragVal = arguments.getInt("val")
        fragImage = arguments.getInt("image")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_image, container, false)
        val text = view.findViewById<TextView>(R.id.text)
        text.text = "Fragment #" + fragVal
        val image = view.findViewById<ImageView>(R.id.imageView1)
        image.setImageResource(fragImage)
        return view
    }

}
