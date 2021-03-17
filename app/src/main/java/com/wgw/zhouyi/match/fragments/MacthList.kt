package com.wgw.zhouyi.match.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.wgw.zhouyi.R

/**
 * Author:Admin
 * Time:2021/3/11 17:26
 * 描述：
 */
class MacthList :Fragment(),View.OnClickListener{
    var btn_darterManage:Button? = null
    var btn_beatManage:Button? = null
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
        btn_darterManage = view.findViewById(R.id.btn_darterManage)
        btn_beatManage = view.findViewById(R.id.btn_beatManage)
        initOnClick()
        return view
    }

    fun initOnClick(){
        btn_darterManage!!.setOnClickListener {
            var navOptions = NavOptions.Builder()
                .build()
            var navController = Navigation.findNavController(it)
            navController.navigate(R.id.fragment_dartermanage, null, navOptions)
        }
        btn_beatManage!!.setOnClickListener{
            var navOptions = NavOptions.Builder()
                .build()
            var bundle = Bundle()
            var navController = Navigation.findNavController(it)
            navController.navigate(R.id.fragment_beatmanage, null, navOptions)
        }
    }

    override fun onClick(p0: View?) {

    }
}