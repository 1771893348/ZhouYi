package com.wgw.zhouyi.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wgw.zhouyi.R


/**
 * Author:Admin
 * Time:2021/1/13 15:51
 * 描述：
 */
class ShopFragment : BaseFragment(){
    companion object{
        lateinit var mShopFragment:ShopFragment
        fun newInstance():ShopFragment{
                mShopFragment = ShopFragment()

            return mShopFragment
        }
    }


    override fun initView(inflater: LayoutInflater, viewGroup: ViewGroup?): View {
        var view = inflater.inflate(R.layout.fragment_shop,viewGroup,false)
        return view
    }

}