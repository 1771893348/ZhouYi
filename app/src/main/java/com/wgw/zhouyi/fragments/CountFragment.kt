package com.wgw.zhouyi.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wgw.zhouyi.R


/**
 * Author:Admin
 * Time:2021/1/13 15:50
 * 描述：
 */
class CountFragment:BaseFragment() {
    companion object{
         lateinit var mCountFragment:CountFragment
        fun newInstance():CountFragment{
                mCountFragment = CountFragment()
            return mCountFragment
        }
    }

    override fun initView(inflater: LayoutInflater, viewGroup: ViewGroup?): View {
        var view = inflater.inflate(R.layout.fragment_count,viewGroup,false)
        return view
    }
}