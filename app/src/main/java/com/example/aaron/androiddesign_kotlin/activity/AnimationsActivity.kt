package com.example.aaron.androiddesign_kotlin.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.adapter.MainMenuRVAdapter
import kotlinx.android.synthetic.main.activity_animations.*

class AnimationsActivity : BaseActivity() {
    private val arrs = arrayOf(
            arrayOf("ViewPagerSlidesActivity屏幕幻灯片", ViewPagerSlidesActivity::class.java)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animations)
        rvMenu.apply {
            //0.添加线条
            addItemDecoration(DividerItemDecoration(this@AnimationsActivity, DividerItemDecoration.VERTICAL))
            //1.设置布局管理器
            layoutManager = LinearLayoutManager(this@AnimationsActivity).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
            //2.adapter
            adapter = MainMenuRVAdapter(arrs, MainMenuRVAdapter.P_VIEWTYPE_LISTDATA) {
                //Anko提供了简单得多的方式通过reified function来启动一个activity
                var intent = Intent(this@AnimationsActivity, it[1] as Class<*>)
                intent.putExtra("title", it[0])
                startActivity(intent)
            }
        }

    }

}
