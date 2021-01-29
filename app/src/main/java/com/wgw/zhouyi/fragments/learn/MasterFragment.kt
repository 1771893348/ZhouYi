package com.wgw.zhouyi.fragments.learn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wgw.zhouyi.R
import com.wgw.zhouyi.fragments.BaseFragment

/**
 * Author:Admin
 * Time:2021/1/26 16:21
 * 描述：
 */
class MasterFragment :BaseFragment(){
    override fun initView(inflater: LayoutInflater, viewGroup: ViewGroup?): View {
        var view = inflater.inflate(R.layout.fragment_master,viewGroup,false)
        return view
    }
}