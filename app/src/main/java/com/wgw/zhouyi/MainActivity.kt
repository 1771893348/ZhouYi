package com.wgw.zhouyi

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

class MainActivity : AppCompatActivity() {
    lateinit var bottom_tab: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_tab = findViewById(R.id.bottom_tab)

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

}