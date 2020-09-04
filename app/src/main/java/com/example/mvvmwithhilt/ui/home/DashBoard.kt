package com.example.mvvmwithhilt.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.databinding.DashBoardFragmentBinding

class DashBoard : Fragment() {

    companion object {
        fun newInstance() = DashBoard()
    }

    val viewModel by viewModels<DashBoardViewModel> ()
    lateinit var binding:DashBoardFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.dash_board_fragment,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}