package com.wgw.zhouyi.match.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wgw.zhouyi.R

/**
 * Author:Admin
 * Time:2021/3/11 17:40
 * 描述：
 */
class DarterInfoFragment:Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_darterinfo,container,false)
        return view
    }
}