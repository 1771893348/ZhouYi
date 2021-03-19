package com.wgw.zhouyi.match.fragments

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.wgw.zhouyi.App
import com.wgw.zhouyi.R
import com.wgw.zhouyi.data.database.AppDatabase
import com.wgw.zhouyi.data.tables.Darter
import com.wgw.zhouyi.match.activitys.MatchMainActivity
import com.wgw.zhouyi.match.interfaces.ImageCallBack
import java.util.*

/**
 * Author:Admin
 * Time:2021/3/11 17:40
 * 描述：
 */
class DarterInfoFragment:Fragment() ,ImageCallBack{
    lateinit var btn_add:Button
    var darter_icon:ImageView?=null
    var darter: Darter?=null
    var edt_name:EditText ?= null
    var edt_age:EditText ?= null
    var edt_synopsis:EditText ?= null
    var darterIcon:String ?= null
    var sp_sex:Spinner ?= null
    var str_sex:String ="男"
    var sexs:Array<String> ?= null

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
        darter = Darter(0,"wgw","wwwww","","男")
        var res = activity!!.resources
        sexs = res.getStringArray(R.array.sexs)
        (activity as MatchMainActivity).addCallBack(this)
        return initView(inflater, container)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as MatchMainActivity).removeCallBack(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    fun initView(inflater: LayoutInflater, container: ViewGroup?):View{
        val view = inflater.inflate(R.layout.fragment_darterinfo, container, false)
        edt_name = view.findViewById(R.id.edt_name)
        edt_age = view.findViewById(R.id.edt_age)
        edt_synopsis = view.findViewById(R.id.edt_synopsis)
        btn_add = view.findViewById(R.id.btn_add)
        sp_sex = view.findViewById(R.id.sp_sex)
        darter_icon = view.findViewById(R.id.darter_icon)
        initListener()
        return view
    }
    fun darterIcon(path: String){

    }
    fun initListener(){

        var arrayAdapter = ArrayAdapter.createFromResource(activity!!, R.array.sexs, android.R.layout.simple_spinner_item)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        sp_sex!!.adapter = arrayAdapter
        sp_sex!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                str_sex = sexs!![p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        darter_icon!!.setOnClickListener{
            (activity as MatchMainActivity).getPicFromAlbm()
        }
        btn_add.setOnClickListener{
            val name = edt_name!!.text.toString()
            val age = edt_age!!.text.toString()
            val synopsis = edt_synopsis!!.text.toString()
            if (null == name || name.equals("")){
                Toast.makeText(activity, "请输入姓名", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (null == age || age.equals("")){
                Toast.makeText(activity, "年龄", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (null == synopsis || synopsis.equals("")){
                Toast.makeText(activity, "简介", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            darter!!.darter_name = name
            darter!!.darter_sex = str_sex
            darter!!.darter_sex = age
            darter!!.darter_info =synopsis

            if (null != darter){
//                App().getDB().darterDao().insertDarter(darter!!)
                AppDatabase.getInstance(activity!!).darterDao().insertDarter(darter!!)
            }
            Navigation.findNavController(it).popBackStack()

        }
    }

    override fun onImageUrl(url: String) {
        Log.i("wgw_onImageUrl","--"+url)
        darter!!.darter_icon = url
        darterIcon = url
        Glide.with(activity!!).load(url).into(darter_icon!!)
    }

}