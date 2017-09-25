package com.example.aaron.androiddesign_kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.aaron.androiddesign_kotlin.R
import kotlinx.android.synthetic.main.item_basedata.view.*

/**
 *注：参数var menus: Array<String>，则val itemClick: (String)
 * Created by Administrator on 2017/9/23.
 */
class BaseDataRVAdapter(var datas: Array<String>, val itemClick: (String) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder1(LayoutInflater.from(parent?.context).inflate(R.layout.item_basedata, parent, false) as TextView, itemClick)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as ViewHolder1).bindData(datas[position])
    }

    override fun getItemCount(): Int = datas.size

    class ViewHolder1(itemView: TextView?, val itemClick: (String) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bindData(text: String) {
            itemView.tvText.text = text
            itemView.setOnClickListener { itemClick(text) }
        }
    }


}