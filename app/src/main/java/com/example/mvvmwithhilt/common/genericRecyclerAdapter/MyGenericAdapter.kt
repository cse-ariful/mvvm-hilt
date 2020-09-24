package com.example.mvvmwithhilt.common.genericRecyclerAdapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmwithhilt.BR


class GenericAdapter<T : GenericModel>(@LayoutRes val layoutId: Int) :
    RecyclerView.Adapter<GenericAdapter.GenericViewHolder<T>>() {

    private val items = mutableListOf<T>()
    private var inflater: LayoutInflater? = null
    private var onItemClickEvent: OnItemClickEvent? = null
    interface OnItemClickEvent {
        fun onClick(view: View, item: Any)
    }
    fun addItems(items: List<T>?) {
        this.items.clear()
        if(items!=null){
            this.items.addAll(items)
        }
        notifyDataSetChanged()
    }

    fun onItemClickEvent(itemClickEvent: OnItemClickEvent?){
        this.onItemClickEvent = itemClickEvent
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> {
        val layoutInflater = inflater ?: LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, layoutId, parent, false)
        return GenericViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: GenericViewHolder<T>, position: Int) {
        val itemViewModel = items[position]
        itemViewModel.adapterPosition = position
        Log.d("genericAdapter", "onBindViewHolder: $position ")
        onItemClickEvent?.let {
            itemViewModel.onItemClickEvent = it }
        holder.bind(itemViewModel)
    }


    class GenericViewHolder<T : GenericModel>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemViewModel: T) {
            binding.setVariable(BR.item, itemViewModel)
            binding.executePendingBindings()
        }

    }


}