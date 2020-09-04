package com.example.mvvmwithhilt.ui.Attendance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.databinding.HostFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
@AndroidEntryPoint
class HostFragment : Fragment() {

    companion object {
        fun newInstance() = HostFragment()
    }

    private val viewModel by viewModels<HostViewModel> ()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:HostFragmentBinding = DataBindingUtil.inflate( inflater, R.layout.host_fragment,container,false);
        viewModel.hostAddress.observe(viewLifecycleOwner, Observer {
            binding.webPortStatus.text=it
        })
        viewModel.running.observe(viewLifecycleOwner, Observer {
            binding.startBtn.text = when(it){
                true->"Stop"
                false->"Start"
            }
        })
        val adapter = AttendanceListAdapter(requireContext())
        binding.recyclerView.adapter=adapter
        viewModel.submittedList.observe(viewLifecycleOwner, Observer {
            adapter.items= it.toMutableList()
            adapter.notifyDataSetChanged()
        })
        binding.startBtn.setOnClickListener {
            GlobalScope.launch {
                viewModel.toggleLocalServer(requireContext())
            }
        }
        return binding.root
    }
}