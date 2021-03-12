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
 * Time:2021/3/11 17:26
 * 描述：
 */
class MacthList :Fragment(){
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initView(inflater,container)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }
    fun initView(inflater: LayoutInflater,container: ViewGroup?):View{
        val view = inflater.inflate(R.layout.fragment_matchlist,container,false)
        return view
    }
}