package com.wgw.zhouyi.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.wgw.zhouyi.R
import com.wgw.zhouyi.adapters.FragmentAdapter
import com.wgw.zhouyi.fragments.learn.ArticleFragment
import com.wgw.zhouyi.fragments.learn.IconsFragment
import com.wgw.zhouyi.fragments.learn.MasterFragment
import com.wgw.zhouyi.fragments.learn.VIdeoFragment


/**
 * Author:Admin
 * Time:2021/1/13 15:52
 * 描述：
 */
class LearnFragment :BaseFragment() {
    lateinit var tablayout_learn: TabLayout
    lateinit var viewpager_learn: ViewPager
    lateinit var viewpagerAdapter:FragmentAdapter
    companion object {
        lateinit var mLearnFragment:LearnFragment

        fun newInstance():LearnFragment{
                mLearnFragment = LearnFragment()

            return mLearnFragment
        }
    }

    override fun initView(inflater: LayoutInflater, viewGroup: ViewGroup?): View {
        var view = inflater.inflate(R.layout.fragment_learn,viewGroup,false)

        tablayout_learn = view.findViewById(R.id.tablayout_learn)
        viewpager_learn = view.findViewById(R.id.viewpager_learn)
        setViewpage(viewpager_learn)
        tablayout_learn.setupWithViewPager(viewpager_learn,true)

        for (i in 0..tablayout_learn.tabCount-1){
            var tab = tablayout_learn.getTabAt(i)
            if (null != tab){
                tab.customView=viewpagerAdapter.getTabView(i)
            }
        }
        return view
    }
    val frames = mutableListOf<BaseFragment>()
    val titles = mutableListOf<String>()

    fun setViewpage(viewPager: ViewPager){

        frames.add(ArticleFragment())
        titles.add("文章")
        frames.add(MasterFragment())
        titles.add("大师简历")
        frames.add(IconsFragment())
        titles.add("图标")
        frames.add(VIdeoFragment())
        titles.add("视频")
        viewpagerAdapter = FragmentAdapter(frames,titles,activity!!,activity!!.supportFragmentManager)
        viewPager.adapter = viewpagerAdapter
    }
}