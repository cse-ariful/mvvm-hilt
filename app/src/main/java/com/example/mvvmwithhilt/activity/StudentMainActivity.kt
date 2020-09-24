package com.example.mvvmwithhilt.activity

import android.os.Bundle
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.adapters.ViewPagerAdapter
import com.example.mvvmwithhilt.common.BaseActivity
import com.example.mvvmwithhilt.ui.courseDetails.CourseDetails
import com.example.mvvmwithhilt.ui.feed.PostFeedFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_student_main.*

@AndroidEntryPoint
class StudentMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_main)
        val pagerAdapter = ViewPagerAdapter(this@StudentMainActivity).apply {
            addFragment(PostFeedFragment.newInstance())
            addFragment(CourseDetails())
        }
        val viewPager = viewPager_student;
        viewPager.apply {
            isUserInputEnabled=false
            adapter=pagerAdapter;

        }
        nav_view.apply {
            navView = this
            setOnNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.action_notification -> {
                        viewPager.setCurrentItem(0)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.action_account -> {
                        viewPager.setCurrentItem(1)
                        return@setOnNavigationItemSelectedListener true
                    }
                    else -> return@setOnNavigationItemSelectedListener false

                }
            }
        }
    }
}