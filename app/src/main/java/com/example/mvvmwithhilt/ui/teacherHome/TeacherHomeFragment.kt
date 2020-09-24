/*
 * Copyright (c) 2020. This file is created by Ariful Jannat Arif at 9/6/20 10:04 AM
 * please Dont modify this file unless prior permission from owner
 *
 * Ariful Jannat Arif
 * software engineer at inverseai.com
 * cse.ariful@gmail.com
 */



package com.example.mvvmwithhilt.ui.teacherHome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.adapters.ViewPagerAdapter
import com.example.mvvmwithhilt.ui.courselist.CourseListBottomSheet
import com.example.mvvmwithhilt.ui.feed.PostFeedFragment
import com.example.mvvmwithhilt.ui.host.HostBottomSheet
import com.google.android.material.bottomnavigation.BottomNavigationView

class TeacherHomeFragment : Fragment() {

    val viewModel by viewModels<TeacherHomeViewModel>()
    lateinit var viewPager: ViewPager2
    lateinit var bottom_nav:BottomNavigationView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.teacher_home_fragment, container, false)
        viewPager=view.findViewById(R.id.teacherHomeViewPager)
        bottom_nav = view.findViewById(R.id.bottom_nav)
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ViewPagerAdapter(requireActivity())
        adapter.addFragment(PostFeedFragment())
        adapter.addFragment(CourseListBottomSheet())
        adapter.addFragment(HostBottomSheet())
        viewPager?.apply {
            isUserInputEnabled=false
            this.adapter=adapter;
        }
        bottom_nav?.apply {
            setOnNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.to_courseListFragment -> {
                        viewPager.setCurrentItem(0)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.to_timelineFragment -> {
                        viewPager.setCurrentItem(1)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.action_students -> {
                        viewPager.setCurrentItem(2)
                        return@setOnNavigationItemSelectedListener true
                    }
                    else -> return@setOnNavigationItemSelectedListener false

                }
            }
        }
    }
    companion object {
        fun newInstance() = TeacherHomeFragment()
    }


}