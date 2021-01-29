package com.wgw.zhouyi.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wgw.zhouyi.R
import com.wgw.zhouyi.fragments.BaseFragment


/**
 * Author:Admin
 * Time:2021/1/13 16:23
 * 描述：
 */
class ViewPagerAdapter(private val fragmentList: ArrayList<BaseFragment>, manager: FragmentManager) : FragmentPagerAdapter(
    manager!!,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
){

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }


}

class FragmentAdapter(
    private val mFragments: List<Fragment>,
    private val mTitles: List<String>,
    private val mContext: Context,
    fm: FragmentManager?
) : FragmentPagerAdapter(fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(i: Int): Fragment {
        return mFragments[i]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitles[position]
    }

    fun getTabView(position: Int): View {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.item_header_learn, null)
        val textView = view.findViewById<TextView>(R.id.item_text)
        textView.text = mTitles[position]
        return view
    }
}

