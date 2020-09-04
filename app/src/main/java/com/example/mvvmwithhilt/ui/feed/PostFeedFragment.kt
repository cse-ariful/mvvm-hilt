package com.example.mvvmwithhilt.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.databinding.PostFeedFragmentBinding
import com.example.mvvmwithhilt.ui.feed.postfeedAdapter.PostFeedAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostFeedFragment : Fragment() {

    lateinit var  binding: PostFeedFragmentBinding
    val viewModel by viewModels<PostFeedViewModel> ()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.post_feed_fragment,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.swipeRefresh.setOnRefreshListener {
            binding.swipeRefresh.isRefreshing=false;
            if(!viewModel.loadingPost.value!!) {
                viewModel.getPosts()
            }
        }
        viewModel.posts.observe(viewLifecycleOwner, Observer {movies ->
            binding.postRecyclerview.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.hasFixedSize()
                it.adapter = PostFeedAdapter(movies)
            }
        })
        viewModel.loadingPost.observe(viewLifecycleOwner, Observer {
            binding.shimmerFrame.visibility = if(it) View.VISIBLE else View.GONE
            binding.swipeRefresh.isEnabled = if(it) false else true
        })
        viewModel.getPosts()
    }
}