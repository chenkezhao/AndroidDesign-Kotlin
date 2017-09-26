package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.os.Handler
import com.example.aaron.androiddesign_kotlin.R
import kotlinx.android.synthetic.main.activity_swipe_refresh_layout.*

class SwipeRefreshLayoutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_refresh_layout)
        swipeLayout.apply {
            isRefreshing = true
            setOnRefreshListener {
                Handler().postDelayed({
                    isRefreshing = false
                }, 5000)
            }
            setColorSchemeColors(
                    resources.getColor(android.R.color.holo_blue_bright),
                    resources.getColor(android.R.color.holo_green_light),
                    resources.getColor(android.R.color.holo_orange_light),
                    resources.getColor(android.R.color.holo_red_light))
        }

        Handler().postDelayed({
            swipeLayout.isRefreshing = false
        }, 1000)
    }
}
