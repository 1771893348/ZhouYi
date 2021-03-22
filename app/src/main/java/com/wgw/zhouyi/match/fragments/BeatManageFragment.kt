package com.wgw.zhouyi.match.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wgw.zhouyi.R
import com.wgw.zhouyi.data.database.AppDatabase
import com.wgw.zhouyi.data.tables.BeatTable
import com.wgw.zhouyi.match.adapters.BeatRecyclerAdapter

/**
 * Author:Admin
 * Time:2021/3/11 17:39
 * 描述：
 */
class BeatManageFragment:Fragment() {
    var btn_add_beat: Button?= null
    var rv_beat:RecyclerView?=null
    var beatAdapter:BeatRecyclerAdapter?=null
    var datas:List<BeatTable>?=null
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initView(inflater,container)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    fun initView(inflater: LayoutInflater,container: ViewGroup?):View{
        val view = inflater.inflate(R.layout.fragment_beatmanage,container,false)
        btn_add_beat = view.findViewById(R.id.btn_add_beat)
        rv_beat = view.findViewById(R.id.rv_beat)
        var linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_beat!!.layoutManager = linearLayoutManager
        datas = AppDatabase.getInstance(activity!!).beatTableDao().getAllBeat()
        beatAdapter = BeatRecyclerAdapter(activity!!,datas!!)
        rv_beat!!.adapter = beatAdapter
        initListener()
        return view
    }
    fun initListener(){
        btn_add_beat!!.setOnClickListener{

        }
    }
}