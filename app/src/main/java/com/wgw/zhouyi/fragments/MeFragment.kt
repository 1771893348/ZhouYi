package com.wgw.zhouyi.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wgw.zhouyi.R

/**
 * Author:Admin
 * Time:2021/1/13 15:52
 * 描述：
 */
class MeFragment :BaseFragment() {

    companion object {
        lateinit var mMeFragment:MeFragment
        fun newInstance():MeFragment{

                mMeFragment = MeFragment()

            return mMeFragment
        }
    }

    override fun initView(inflater: LayoutInflater, viewGroup: ViewGroup?): View {
        var view = inflater.inflate(R.layout.fragment_me,viewGroup,false)
        return view
    }

}