package com.example.aaron.androiddesign_kotlin.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.example.aaron.androiddesign_kotlin.R
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast


/**
 *
 * Created by aaron on 2017/9/25.
 */
class TabLayoutPagerAdapter(var context: Context, var titils: Array<String>) : PagerAdapter() {


    //决定是否与一个特定的页面视图返回的关键对象
    override fun isViewFromObject(view: View?, `object`: Any?): Boolean = view == `object`

    override fun getCount(): Int = titils.size

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val rlLayout = LayoutInflater.from(context).inflate(R.layout.item_tablayout, null) as RelativeLayout
        val tv = rlLayout.findViewById<TextView>(R.id.tvText)
        tv.text = titils[position]

        val mRecyclerView = rlLayout.findViewById<RecyclerView>(R.id.rvList)
        mRecyclerView.apply {
            //1.添加线条
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            //2.设置布局管理器
            layoutManager = LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
            //3.adapter
            adapter = BaseDataRVAdapter(initData()){
                Toast.makeText(context,"点击了"+(it),Toast.LENGTH_LONG).show()
            }
        }

        container!!.addView(rlLayout)//添加页卡
        return rlLayout
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)//删除选项卡
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titils[position];
    }

    private fun initData(): Array<String> {
        return Array(100, { i -> (i + 1).toString() })
    }
}