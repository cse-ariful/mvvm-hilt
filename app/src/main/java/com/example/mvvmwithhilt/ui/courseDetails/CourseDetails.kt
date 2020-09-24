package com.example.mvvmwithhilt.ui.courseDetails

import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mvvmwithhilt.common.BaseActivity
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.adapters.ViewPagerAdapter
import com.example.mvvmwithhilt.common.BaseBottomSheet
import com.example.mvvmwithhilt.databinding.CourseDetailsFragmentBinding
import com.example.mvvmwithhilt.ui.feed.PostFeedFragment
import com.example.mvvmwithhilt.ui.host.HostBottomSheet


class CourseDetails : BaseBottomSheet<CourseDetailsFragmentBinding,CourseDetailsViewModel>(){
    override val viewModel by viewModels<CourseDetailsViewModel>()

    override fun getLayoutResId(): Int = R.layout.course_details_fragment

    override fun init() {
        binding.viewPager.apply {
            adapter = getAdapter()
            isUserInputEnabled=false
        }
    }

    private fun getAdapter(): FragmentStateAdapter? {
        val  adapter = ViewPagerAdapter(requireActivity())
        adapter.addFragment(HostBottomSheet.newInstance())
        adapter.addFragment(PostFeedFragment.newInstance())
        return adapter
    }

    override fun onStart() {
        super.onStart()
        //hideActivityBottomNav()
    }

    override fun onStop() {
        super.onStop()
       // showActivityBottomNav()
    }
    fun hideActivityBottomNav(){
        (requireActivity() as BaseActivity).hideBottomNav()
    }
    fun showActivityBottomNav(){
        (requireActivity() as BaseActivity).showBottomNav()
    }


}