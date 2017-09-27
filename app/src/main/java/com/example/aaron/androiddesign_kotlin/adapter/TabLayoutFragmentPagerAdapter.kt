package com.example.aaron.androiddesign_kotlin.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.aaron.androiddesign_kotlin.activity.TabLayoutActivity2
import com.example.aaron.androiddesign_kotlin.fragment.TestFragment

/**
 *
 * Created by aaron on 2017/9/25.
 */
class TabLayoutFragmentPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
//    lateinit 的使用条件必须满足：
//    类体中用 var 声明的属性且不在主构造函数中
//    没有自定义的 getter 或 setter
//    属性类型非 null
//    不能为原始类型
//    在一个 lateinit 属性初始化前访问它将会抛出异常：lateinit property fragments has not been initialized

    private val TAB_NUM = TabLayoutActivity2.tabTitles.size

    private var fragments = Array<Fragment>(TAB_NUM, { i -> TestFragment.newInstance(i.toString()) })

    init {
        //主构造函数不能包含任意代码。初始化代码可以放在以 init 做前缀的初始化块内
    }

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = TAB_NUM

    override fun getPageTitle(position: Int): CharSequence = TabLayoutActivity2.tabTitles[position]


}