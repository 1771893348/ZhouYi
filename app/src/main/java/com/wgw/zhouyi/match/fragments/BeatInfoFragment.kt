package com.wgw.zhouyi.match.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.wgw.zhouyi.R

/**
 * Author:Admin
 * Time:2021/3/11 17:40
 * 描述：
 */
class BeatInfoFragment:Fragment() {
    var img_darter1_icon:ImageView?=null
    var img_darter2_icon:ImageView?=null
    var txt_darter1_name:TextView?=null
    var txt_darter2_name:TextView?=null
    var txt_darter1_content:TextView?=null
    var txt_darter2_content:TextView?=null
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
        val view = inflater.inflate(R.layout.fragment_beatinfo,container,false)
        img_darter1_icon = view.findViewById(R.id.img_darter1_icon)
        img_darter2_icon = view.findViewById(R.id.img_darter2_icon)
        txt_darter1_name = view.findViewById(R.id.txt_darter1_name)
        txt_darter2_name = view.findViewById(R.id.txt_darter2_name)
        txt_darter1_content = view.findViewById(R.id.txt_darter1_content)
        txt_darter2_content = view.findViewById(R.id.txt_darter2_content)

        return view
    }
}