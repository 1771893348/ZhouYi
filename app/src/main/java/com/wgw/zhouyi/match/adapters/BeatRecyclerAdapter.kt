package com.wgw.zhouyi.match.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wgw.zhouyi.R
import com.wgw.zhouyi.data.database.AppDatabase
import com.wgw.zhouyi.data.tables.BeatTable
import com.wgw.zhouyi.data.tables.Darter

/**
 * Author:Admin
 * Time:2021/3/18 17:13
 * 描述：
 */
class BeatRecyclerAdapter(var context: Context, var datas:List<BeatTable>) : RecyclerView.Adapter<BeatRecyclerAdapter.ViewHold>() {
    class ViewHold(itemView: View) :RecyclerView.ViewHolder(itemView){
        var img_darter_icon:ImageView = itemView.findViewById(R.id.img_darter_icon)
        var tv_darter_name:TextView = itemView.findViewById(R.id.tv_darter_name)
        var tv_darter_sex:TextView = itemView.findViewById(R.id.tv_darter_sex)
        var img_darter2_icon:ImageView = itemView.findViewById(R.id.img_darter2_icon)
        var tv_darter2_name:TextView = itemView.findViewById(R.id.tv_darter2_name)
        var tv_darter2_sex:TextView = itemView.findViewById(R.id.tv_darter2_sex)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHold {
        var itemView = LayoutInflater.from(context).inflate(R.layout.item_beat_view,parent,false)
        var viewHold = ViewHold(itemView)
        return viewHold
    }

    override fun onBindViewHolder(holder: ViewHold, position: Int) {
        var beat = datas[position]
        var darter1 = AppDatabase.getInstance(context).darterDao().getDarterByUids(beat.blu_uid)
        var darter2 = AppDatabase.getInstance(context).darterDao().getDarterByUids(beat.red_uid)
        Glide.with(context).load(darter1.darter_icon).into(holder.img_darter_icon)
        holder.tv_darter_name.setText(darter1.darter_name)
        holder.tv_darter_sex.setText(darter1.darter_sex)
        Glide.with(context).load(darter2.darter_icon).into(holder.img_darter2_icon)
        holder.tv_darter2_name.setText(darter2.darter_name)
        holder.tv_darter2_sex.setText(darter2.darter_sex)
    }

    override fun getItemCount(): Int {
        return datas.size
    }
}