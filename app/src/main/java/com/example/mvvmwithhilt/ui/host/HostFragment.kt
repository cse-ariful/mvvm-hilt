package com.example.mvvmwithhilt.ui.host

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.common.BaseFragment
import com.example.mvvmwithhilt.databinding.HostFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.reflect.typeOf

@AndroidEntryPoint
class HostFragment : BaseFragment<HostFragmentBinding,HostViewModel>() {
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
        fun newInstance(): HostFragment {
            return HostFragment();
        }
    }

}