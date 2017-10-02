package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.text.Html.fromHtml
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.adapter.PagerAdapter
import kotlinx.android.synthetic.main.activity_pager.*

class PagerActivity : BaseActivity() {

    private var layouts: IntArray? = null

    init {
        layouts = intArrayOf(R.mipmap.ic_discount, R.mipmap.ic_food, R.mipmap.ic_movie, R.mipmap.ic_travel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.requestFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_pager)
//        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        addBottomDots(0)
        val adapter = PagerAdapter(supportFragmentManager, layouts)
        viewpager.adapter = adapter

        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                addBottomDots(position)
                if (position == layouts!!.size - 1) {
                    btn_next.text = "GOT IT"
                    btn_skip.visibility = View.GONE
                } else {
                    btn_next.text = "NEXT"
                    btn_skip.visibility = View.VISIBLE
                }
            }
        })


        btn_next.setOnClickListener {
            val current = getItem(+1)
            if (current < layouts!!.size) {
                // move to next screen
                viewpager.currentItem = current
            } else {
                finish()
            }
        }
        btn_skip.setOnClickListener { finish() }
    }

    private fun addBottomDots(currentPage: Int) {
        val dots = arrayOfNulls<TextView>(layouts!!.size)
        val colorsActive = resources.getIntArray(R.array.array_dot_active)
        dotsLayout.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.text = fromHtml("&#8226;")
            dots[i]!!.textSize = 35f
            dotsLayout.addView(dots[i])
        }

        if (dots.isNotEmpty())
            dots[currentPage]!!.setTextColor(colorsActive[currentPage])
    }

    private fun getItem(i: Int): Int {
        return viewpager.currentItem + i
    }
}
