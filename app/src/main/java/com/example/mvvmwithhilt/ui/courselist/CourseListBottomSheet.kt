package com.example.mvvmwithhilt.ui.courselist

import android.content.Intent
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mvvmwithhilt.Courotines
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.activity.AuthenticationActivity
import com.example.mvvmwithhilt.common.BaseBottomSheet
import com.example.mvvmwithhilt.common.genericRecyclerAdapter.GenericAdapter
import com.example.mvvmwithhilt.databinding.CoursesFragmentBinding
import com.example.mvvmwithhilt.model.CourseModel
import com.example.mvvmwithhilt.repositories.PostRepositories

class CourseListBottomSheet : BaseBottomSheet<CoursesFragmentBinding, CoursesViewModel>() {
    override val viewModel by viewModels<CoursesViewModel> ()
    override fun getLayoutResId() = R.layout.courses_fragment
    override fun init() {
        Courotines.ioThenMain({
            binding.shimmerFrame.visibility=View.VISIBLE
            PostRepositories().getCourses()
        },{
            binding.courseListRecycler.adapter = GenericAdapter<CourseModel>(R.layout.course_list_item).apply {
                addItems(it)
                val eventListener = object : GenericAdapter.OnItemClickEvent {
                    override fun onClick(view: View, item: Any) {
                        viewModel.onCourseListIemEvent(view,item as CourseModel)
                        requireActivity().startActivity(Intent(requireContext(),AuthenticationActivity::class.java))
                        //Toast.makeText(requireContext(), "clicked ${item.title}",Toast.LENGTH_SHORT).show()
                    }
                }
                onItemClickEvent(eventListener)
            }
            binding.shimmerFrame.visibility=View.GONE

        })
    }





}