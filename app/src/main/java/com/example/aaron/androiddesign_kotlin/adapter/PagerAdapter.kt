package com.example.aaron.androiddesign_kotlin.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.aaron.androiddesign_kotlin.fragment.ImageFragment


class PagerAdapter(fragmentManager: FragmentManager, val ITEMS: IntArray?) : FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return ITEMS!!.size
    }

    override fun getItem(position: Int): Fragment {
        return init(position, ITEMS!![position])
    }

    fun init(valueF: Int, i: Int): ImageFragment {
        val truitonFrag = ImageFragment()
        // Supply val input as an argument.
        val args = Bundle()
        args.putInt("val", valueF)
        args.putInt("image", i)
        truitonFrag.arguments = args
        return truitonFrag
    }
}