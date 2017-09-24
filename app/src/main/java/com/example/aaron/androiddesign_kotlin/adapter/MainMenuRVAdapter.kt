package com.example.aaron.androiddesign_kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.aaron.androiddesign_kotlin.R
import kotlinx.android.synthetic.main.item_menu.view.*
import java.io.Serializable

/**
 *注：参数var menus: Array<String>，则val itemClick: (String)
 * Created by Administrator on 2017/9/23.
 */
class MainMenuRVAdapter(var menus: Array<Array<Serializable>>, var viewType: Int, val itemClick: (Array<Serializable>) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val P_VIEWTYPE_LISTDATA: Int = 1
    }

    override fun getItemViewType(position: Int): Int {
        return viewType//super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var layoutInflater = LayoutInflater.from(parent?.context)
        if (P_VIEWTYPE_LISTDATA == viewType) {
            return ViewHolder1(layoutInflater.inflate(R.layout.item_menu, parent, false) as TextView, itemClick)
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


    class ViewHolder1(itemView: TextView?, val itemClick: (Array<Serializable>) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bindData(arr: Array<Serializable>) {
            arr.apply {
                itemView.tvMenu.text = this[0].toString()
                itemView.setOnClickListener { itemClick(this) }
            }
//            itemView.setOnClickListener(View.OnClickListener {
//                Toast.makeText(itemView.context,"来了啊",Toast.LENGTH_LONG).show()
//            })
        }
    }

    class ViewHolder404(itemView: TextView?) : RecyclerView.ViewHolder(itemView) {
        fun bindData(text: String = "404") {
            itemView.tvMenu.text = text
        }
    }

}