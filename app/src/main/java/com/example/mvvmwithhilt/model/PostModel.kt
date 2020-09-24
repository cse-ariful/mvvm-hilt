package com.example.mvvmwithhilt.model
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.common.genericRecyclerAdapter.GenericModel
import com.google.gson.annotations.SerializedName


data class PostModel(
    @SerializedName("author")
    var author: String,
    @SerializedName("comment")
    var comment: Int,
    @SerializedName("content")
    var content: String,
    @SerializedName("downVote")
    var downVote: Int,
    @SerializedName("images")
    var images: List<String>,
    @SerializedName("title")
    var title: String,
    @SerializedName("upVotes")
    var upVotes: Int,
    @SerializedName("time")
    var eventTime: String
): GenericModel(){}



@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, urls: List<String>)   {
    urls.let {
        if(urls.isNotEmpty()) Glide.with(view.context).load(urls.get(0)).placeholder(R.drawable.loading).into(view)
    }
}