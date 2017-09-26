package com.example.aaron.androiddesign_kotlin.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SlidingPaneLayout
import android.view.View
import com.example.aaron.androiddesign_kotlin.R
import kotlinx.android.synthetic.main.activity_sliding_pane_layout.*

class SlidingPaneLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sliding_pane_layout)

        splLayout.apply {
            setPanelSlideListener(object : SlidingPaneLayout.PanelSlideListener {
                override fun onPanelSlide(panel: View?, slideOffset: Float) {
                    //滑动效果
                    tvLeft.scaleY = slideOffset / 2 + 0.5F
                    tvLeft.scaleX = slideOffset / 2 + 0.5F
                    tvRight.scaleY = 1 - slideOffset / 5
                }

                override fun onPanelClosed(panel: View?) {
                }

                override fun onPanelOpened(panel: View?) {
                }
            })
        }
    }
}
