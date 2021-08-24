package com.example.bookstore

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPageAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm){

    val pageNumber = 3

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> FragmentOne()
            1 -> FragmentTwo()
            3 -> FragmentThree()

            else -> FragmentOne()
        }
    }

    override fun getCount(): Int {
        return pageNumber
    }
}