package com.example.mvvmwithhilt.ui.Attendance

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.databinding.LayoutAttandanceItemBinding
import com.example.mvvmwithhilt.model.AttendanceModel
import javax.inject.Inject

class AttendanceListAdapter @Inject constructor(val context: Context) : RecyclerView.Adapter<AttendanceListAdapter.ViewHolder>() {
    var  items:MutableList<AttendanceModel>  = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(  R.layout.layout_attandance_item,parent,false)
        val  binding:LayoutAttandanceItemBinding =LayoutAttandanceItemBinding.bind(view)// DataBindingUtil.inflate(LayoutInflater.from(context), viewType,parent,false);
        return ViewHolder(binding);
    }
    override fun getItemCount(): Int {
        return items.size
    }
    fun getItem(position: Int):AttendanceModel{
        return items?.get(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position));
    }

    class ViewHolder(val itemBinding: LayoutAttandanceItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(model: AttendanceModel) {
            itemBinding.item = model
        }

    }
}