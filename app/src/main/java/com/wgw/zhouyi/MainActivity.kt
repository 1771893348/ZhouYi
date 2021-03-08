package com.wgw.zhouyi

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wgw.zhouyi.fragments.CountFragment
import com.wgw.zhouyi.fragments.LearnFragment
import com.wgw.zhouyi.fragments.MeFragment
import com.wgw.zhouyi.fragments.ShopFragment
import com.wgw.zhouyi.fragments.learn.UserBean
import java.io.*

class MainActivity : AppCompatActivity() {
    lateinit var bottom_tab: BottomNavigationView

    var userCityMap = mutableMapOf<String, MutableList<UserBean>>()
    var userGroupMap = mutableMapOf<Int, MutableList<UserBean>>()
    var userSortGroupMap = mutableMapOf<Int, MutableList<UserBean>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_tab = findViewById(R.id.bottom_tab)
//        readTxt()
        replaceFragment(CountFragment())
        bottom_tab.setOnNavigationItemSelectedListener {
            Log.i("wgw----","===NavigationItemSelected=="+it.itemId)
            when (it.itemId){
                    R.id.navigation_home ->{
                        replaceFragment(CountFragment())
                        it.setChecked(true)
                }
                R.id.navigation_shop ->{
                    replaceFragment(ShopFragment())
                    it.setChecked(true)
                }
                R.id.navigation_learn ->{
                    replaceFragment(LearnFragment())
                    it.setChecked(true)
                }
                R.id.navigation_me ->{
                    replaceFragment(MeFragment())
                    it.setChecked(true)
                }
            }


            true
        }


    }

    fun replaceFragment(fragment:Fragment){
        Log.i("wgw----","===replaceFragment==")
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragments,fragment)
        transaction.commit()
    }
    fun grouping(){
        userCityMap.forEach(){
//            it.value.forEach {
//                Log.i("wgw===grouping=",it.name)
//            }
            for ( i in 0 .. it.value.size-1){
                var index = (i+1)%4
                var userlist = userGroupMap[index]
                if (null == userlist){
                    userlist = mutableListOf(it.value[i])
                    userGroupMap[index] = userlist
                }else{
                    userlist.add(it.value[i])
                }
            }
        }
        getSortGroup()
    }

    fun getSortGroup(){
        var index:Int = 1
        for (i in 1.. 4 step 2){
            Log.i("wgw==getSortGroup=",i.toString())
            userSortGroupMap[index] =userGroupMap[i]!!
        }
        for (i in 2.. 4 step 2){
            Log.i("wgw==getSortGroup=",i.toString())
            userSortGroupMap[index] =userGroupMap[i]!!
        }
    }

    fun readTxt(){
        val am: AssetManager = assets
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