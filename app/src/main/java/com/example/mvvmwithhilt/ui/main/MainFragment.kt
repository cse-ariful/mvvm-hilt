package com.example.mvvmwithhilt.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.model.ResultData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.*

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val respositoriesList= mainViewModel.getRepositoriesList()
        respositoriesList.observe(viewLifecycleOwner, Observer { resultData->
            when(resultData){
                is ResultData.Loading ->{
                progressBar.visibility=View.VISIBLE
                }
                is ResultData.Success->{

                    progressBar.visibility=View.GONE
                }
                is ResultData.Failed->{
                    progressBar.visibility=View.GONE
                }
                is ResultData.Exception->{
                    progressBar.visibility=View.GONE
                }
            }
        })

    }

}