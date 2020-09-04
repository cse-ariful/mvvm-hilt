package com.example.mvvmwithhilt.ui.feed.postfeedAdapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.databinding.PostItemLayoutBinding
import com.example.mvvmwithhilt.models.PostModel

class PostFeedAdapter(val postItems:List<PostModel>): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DataBindingUtil.inflate<PostItemLayoutBinding>(
            LayoutInflater.from(parent.context),
            R.layout.post_item_layout,
            parent,
            false)
    )

    override fun getItemCount(): Int {
        return postItems.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.item = geItem(position)
    }

    private fun geItem(position: Int): PostModel? {
        return postItems.get(position)
    }
}