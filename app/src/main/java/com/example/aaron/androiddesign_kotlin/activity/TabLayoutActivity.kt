package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.adapter.TabLayoutPagerAdapter
import kotlinx.android.synthetic.main.activity_tab_layout.*

class TabLayoutActivity : BaseActivity() {

    var tabTitles = arrayOf("TABL1","TAB2","TAB3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        setTitle(intent.getStringExtra("title")!!)
        initBack()

        //第一步
        tblTitle.apply {
            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabSelected(tab: TabLayout.Tab?) {
                }
            })
            setupWithViewPager(vpPager,true)

            //设置标题
            for(i in tabTitles.indices){
                addTab(newTab().setText(tabTitles[i]))
            }
        }
        //第二步
        vpPager.apply {
            addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tblTitle))
            adapter = TabLayoutPagerAdapter(this@TabLayoutActivity,tabTitles)
        }
    }
}
