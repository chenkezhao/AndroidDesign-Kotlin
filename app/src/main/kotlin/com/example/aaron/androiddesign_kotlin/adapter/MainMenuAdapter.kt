package com.example.aaron.androiddesign_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.aaron.androiddesign_kotlin.R

/**
 *
 * Created by aaron on 2017/9/22.
 */
class MainMenuAdapter(context: Context, menus: Array<String>) : BaseAdapter() {

    private val layoutInflater = LayoutInflater.from(context)
    private var menus = menus;

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //Elvis 操作符  ?:  ,如果 ?: 左侧表达式⾮空，elvis 操作符就返回其左侧表达式，否则返回右侧表达式。 请注意，当且仅当左侧为空时，才会对右侧表达式求值。
        return (convertView ?: layoutInflater.inflate(R.layout.item_menu, parent, false) as TextView).also {
            setMenu(it as TextView, menus[position])
            with(it) {
                setText(menus[position])
            }
        }
    }
    private fun setMenu(tv: TextView, menu: String) {
        with(tv) {
            setText(menu)
        }
    }
    override fun getItem(position: Int): Any = menus[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = menus.size

}