package com.example.mvvmwithhilt.ui.host

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.common.BaseBottomSheet
import com.example.mvvmwithhilt.databinding.HostFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HostBottomSheet : BaseBottomSheet<HostFragmentBinding,HostViewModel>() {
    override val viewModel: HostViewModel by viewModels<HostViewModel>()

    override fun getLayoutResId() = R.layout.host_fragment

    override fun init() {
        val adapter = AttendanceListAdapter(requireContext())
        binding.recyclerView.adapter=adapter
        viewModel.submittedList.observe(viewLifecycleOwner, Observer {
            adapter.items= it.toMutableList()
            adapter.notifyDataSetChanged()
        })

    }

    companion object{
        fun newInstance(): HostBottomSheet {
            return HostBottomSheet();
        }
    }

}