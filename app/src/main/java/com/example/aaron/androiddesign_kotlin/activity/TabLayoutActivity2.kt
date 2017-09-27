package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.adapter.TabLayoutFragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_tab_layout.*

class TabLayoutActivity2 : BaseActivity() {
    companion object {
        open val tabTitles = Array<String>(10, { i -> "TAB" + (i + 1) })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        //第一步
        tblTitle.apply {
            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabSelected(tab: TabLayout.Tab?) {
                }
            })
            setupWithViewPager(vpPager, true)

            //设置标题
            for (i in tabTitles.indices) {
                addTab(newTab().setText(tabTitles[i]))
            }
        }
        //第二步
        vpPager.apply {
            addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tblTitle))
            adapter = TabLayoutFragmentPagerAdapter(supportFragmentManager)
            //Alternatively, you can use the method provided by ViewPager to set how many page instances you want the system to keep in memory on either side of your current page.
            //设置保存页面活动数量，但会消耗更多内存，按实际来设置
            offscreenPageLimit = tabTitles.size
        }
    }
}
