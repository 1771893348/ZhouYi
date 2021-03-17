package com.wgw.zhouyi.match.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.wgw.zhouyi.R

/**
 * Author:Admin
 * Time:2021/3/11 17:39
 * 描述：
 */
class DarterManageFragment:Fragment() {
    var btn_add_darter:Button?=null
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
        val view = inflater.inflate(R.layout.fragment_dartersmanage,container,false)
        btn_add_darter = view.findViewById(R.id.btn_add_darter)
        iniListener()
        return view
    }
    fun iniListener(){
        btn_add_darter!!.setOnClickListener{
            var navOptions = NavOptions.Builder()
                    .build();
            Navigation.findNavController(it).navigate(R.id.fragment_dartinfo,null,navOptions)
        }
    }
}