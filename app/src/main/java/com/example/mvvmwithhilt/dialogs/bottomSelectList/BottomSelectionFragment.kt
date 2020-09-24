/*
 * Copyright (c) 2020. This file is created by Ariful Jannat Arif at 9/11/20 12:04 AM
 * please Dont modify this file unless prior permission from owner
 *
 * Ariful Jannat Arif
 * software engineer at inverseai.com
 * cse.ariful@gmail.com
 */

package com.example.mvvmwithhilt.dialogs.bottomSelectList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.common.BaseBottomSheet
import com.example.mvvmwithhilt.common.genericRecyclerAdapter.GenericAdapter
import com.example.mvvmwithhilt.databinding.BottomSelectionLayoutBinding
import com.example.mvvmwithhilt.model.DummyViewModel
import com.example.mvvmwithhilt.model.SelectionModel
import com.example.mvvmwithhilt.utility.IntentKeys
import java.io.Serializable

const val ARG_ITEM_COUNT = "item_count"

class BottomSelectionFragment() : BaseBottomSheet<BottomSelectionLayoutBinding,DummyViewModel>(){
    override val viewModel: DummyViewModel by viewModels<DummyViewModel>()
    lateinit var callback: BottomSheetCallback
      var submitOnSelect:Boolean=false
    val listItems = MutableLiveData<List<SelectionModel>>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitOnSelect = arguments?.getBoolean(IntentKeys.SUBMIT_ON_SELECT,true)!!
        listItems.value=arguments?.getSerializable(IntentKeys.ARG_ITEMS) as List<SelectionModel>
    }
    override fun onStart() {
        super.onStart()
        listItems.observe(viewLifecycleOwner, Observer {
            binding.recyclerView.adapter = GenericAdapter<SelectionModel>(R.layout.bottom_selection_item).apply{
                addItems(listItems.value)
                val eventListener = object : GenericAdapter.OnItemClickEvent {
                    override fun onClick(view: View, item: Any) {
                        val model = item as SelectionModel
                        val list =listItems.value
                        val index = list?.indexOf(model)
                        index?.let {
                            if(!item.radioItem)
                                list[it].selected=!list[index].selected }
                        if(submitOnSelect && item.radioItem){
                            callback.let {
                                callback.onSubmit(list)
                                dismiss()
                            }
                        }
                        listItems.postValue(list)
                    }
                }
                onItemClickEvent(eventListener)
            }
        })

    }
    companion object {
        fun newInstance(items:List<SelectionModel>,title:String): BottomSelectionFragment =
            BottomSelectionFragment()
                .apply {
                    val arguments = Bundle().apply {
                        putSerializable(IntentKeys.ARG_ITEMS, items as Serializable)
                        putString(IntentKeys.ARG_TITLE,title)
                    }
                    setArguments(arguments)
                }
    }

    override fun getLayoutResId(): Int = R.layout.bottom_selection_layout
    override fun init() {
    }
}