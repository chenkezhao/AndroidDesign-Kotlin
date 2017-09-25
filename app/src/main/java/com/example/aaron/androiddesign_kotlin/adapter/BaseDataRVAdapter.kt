package com.example.aaron.androiddesign_kotlin.adapter

import android.support.v7.widget.CardView
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
class BaseDataRVAdapter(var datas: Array<String>,val type:Int = 1, val itemClick: (String) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        val TYPE_TOOLBAR_ACTIVITY = 2
    }

    override fun getItemViewType(position: Int): Int {
        return type
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_TOOLBAR_ACTIVITY){
            return ViewHolder2(LayoutInflater.from(parent?.context).inflate(R.layout.item_toolbar, parent, false) as CardView, itemClick)
        }else{
            return ViewHolder1(LayoutInflater.from(parent?.context).inflate(R.layout.item_basedata, parent, false) as TextView, itemClick)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if(holder is ViewHolder1){
            holder.bindData(datas[position])
        }else if(holder is ViewHolder2){
            holder.bindData(datas[position],position)
        }
    }

    override fun getItemCount(): Int = datas.size

    class ViewHolder1(itemView: TextView?, val itemClick: (String) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bindData(text: String) {
            itemView.tvText.text = text
            itemView.setOnClickListener { itemClick(text) }
        }
    }
    class ViewHolder2(itemView: CardView?, val itemClick: (String) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bindData(text: String,position:Int) {
            itemView.apply {
                tvText.text = text
                //手动更改高度，不同位置的高度有所不同
                tvText.height = (500 + (position % 3) * 100)
                setOnClickListener { itemClick(text) }
            }
        }
    }


}