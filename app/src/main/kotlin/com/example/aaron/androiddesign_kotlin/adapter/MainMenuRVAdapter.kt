package com.example.aaron.androiddesign_kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.aaron.androiddesign_kotlin.R
import kotlinx.android.synthetic.main.item_menu.view.*

/**
 *
 * Created by Administrator on 2017/9/23.
 */
class MainMenuRVAdapter(arrs: Array<String>, viewType: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val P_VIEWTYPE_LISTDATA:Int = 1;
    }
    private var menus = arrs
    private var viewType = viewType

    override fun getItemViewType(position: Int): Int {
        return viewType//super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var layoutInflater = LayoutInflater.from(parent?.context)
        if (P_VIEWTYPE_LISTDATA == viewType) {
            return ViewHolder1(layoutInflater.inflate(R.layout.item_menu, parent, false) as TextView)
        } else {
            return ViewHolder404(layoutInflater.inflate(R.layout.view_404, parent, false) as TextView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is ViewHolder1) {
            holder.bindData(menus[position])
        } else if (holder is ViewHolder404) {
            holder.bindData()
        }
    }

    override fun getItemCount(): Int = menus.size


    class ViewHolder1(itemView: TextView?) : RecyclerView.ViewHolder(itemView) {
        fun bindData(text: String) {
            itemView.tvMenu.text = text
        }
    }

    class ViewHolder404(itemView: TextView?) : RecyclerView.ViewHolder(itemView) {
        fun bindData(text: String = "404") {
            itemView.tvMenu.text = text
        }
    }

}