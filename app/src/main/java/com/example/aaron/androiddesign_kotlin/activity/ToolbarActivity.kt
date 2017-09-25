package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.adapter.BaseDataRVAdapter
import kotlinx.android.synthetic.main.activity_toolbar.*

class ToolbarActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
        rvList.apply {
            //1.添加线条
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            //2.设置布局管理器
            layoutManager = LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
            //3.adapter
            adapter = BaseDataRVAdapter(initData()){
                Toast.makeText(context,"点击了"+(it), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun initData(): Array<String> {
        return Array(100, { i -> (i + 1).toString() })
    }
}
