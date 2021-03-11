package com.wgw.zhouyi.fragments

import android.content.res.AssetManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wgw.zhouyi.R
import com.wgw.zhouyi.fragments.learn.UserBean
import java.io.*
import java.lang.StringBuilder


/**
 * Author:Admin
 * Time:2021/1/13 15:50
 * 描述：
 */
class CountFragment:BaseFragment() {
    var userCityMap = mutableMapOf<String, MutableList<UserBean>>()
    var userGroupMap = mutableMapOf<Int, MutableList<UserBean>>()
    var userSortGroupMap = mutableMapOf<Int, MutableList<UserBean>>()
    var groupSum = 32
    lateinit var textShow:TextView
    companion object{
         lateinit var mCountFragment:CountFragment
        fun newInstance():CountFragment{
                mCountFragment = CountFragment()
            return mCountFragment
        }
    }

    override fun initView(inflater: LayoutInflater, viewGroup: ViewGroup?): View {
        var view = inflater.inflate(R.layout.fragment_count, viewGroup, false)
        textShow = view.findViewById(R.id.textShow)
        readTxt()
        ergodic()
        return view
    }
    fun grouping(){
        var indexFlag = 0
        userCityMap.forEach(){
//            it.value.forEach {
//                Log.i("wgw===grouping=",it.name)
//            }
            for ( i in 0 .. it.value.size-1){
                var index = indexFlag%groupSum+1
                var userlist = userGroupMap[index]
                if (null == userlist){
                    userlist = mutableListOf(it.value[i])
                    userGroupMap[index] = userlist
                }else{
                    getLowList(index).add(it.value[i])
                }
                indexFlag++
            }
        }
        getSortGroup()
    }

    fun getLowList(i:Int):MutableList<UserBean>{
        var lowIndex=i
        var lowSize = Int.MAX_VALUE
        userGroupMap.forEach(){

            if (it.value.size < lowSize){
                lowSize = it.value.size
                lowIndex = it.key
            }
        }
        return userGroupMap[lowIndex]!!
    }

    fun getSortGroup(){
        var index:Int = 1
        userGroupMap.forEach {
                Log.i("wgw===getSortGroup=",it.key.toString())
            }
        for (i in 1.. groupSum step 2){
            userSortGroupMap[index] =userGroupMap[i]!!
            index++
        }
        for (i in 2.. groupSum step 2){
            userSortGroupMap[index] =userGroupMap[i]!!
            index++
        }
    }

    fun ergodic(){
        var sb = StringBuilder()
        userSortGroupMap.forEach {
            Log.i("wgw===getSortGroup=",it.key.toString())
            sb.append("\r\n")
            sb.append("第"+it.key+"组")
            sb.append("\r\n")
            it.value.forEach(){
                sb.append("姓名："+it.name +"   省份："+it.city)
                sb.append("\r\n")
            }
        }
        textShow.setText(sb.toString())
    }

    fun readTxt(){
        val am: AssetManager = activity!!.assets
        try {
            var ls: InputStream = am.open("user.txt")
//            val code: String = getCode(ls)
//            ls = am.open("user.txt")
            val br = BufferedReader(InputStreamReader(ls, "utf-8"))

            var line: String ?= null
            while ( br.readLine().also { line = it } != null) {

                var list = line!!.split(" ")
                val city = list[0]
                val name = list[1]
                Log.i("wgw--readTxt-",line+"==="+city+"--"+name)
                var user:UserBean = UserBean()
                user.name =name
                user.city = city
                var userlist = userCityMap[city]
                if (null == userlist){
                    userlist = mutableListOf(user)
                    userCityMap[city] = userlist
                }else{
                    userlist.add(user)
                }
            }
            grouping()

        } catch (e: IOException) {
// TODO Auto-generated catch block
            e.printStackTrace()
        }

    }
    fun getCode(ls: InputStream): String {
        try {
            val bin = BufferedInputStream(ls)
            val p: Int
            p = (bin.read() shl 8) + bin.read()
            var code: String? = null
            code = when (p) {
                0xefbb -> "UTF-8"
                0xfffe -> "Unicode"
                0xfeff -> "UTF-16BE"
                else -> "GBK"
            }
            ls.close()
            return code
        } catch (e: IOException) {
// TODO Auto-generated catch block
            e.printStackTrace()
        }
        return ""
    }

}