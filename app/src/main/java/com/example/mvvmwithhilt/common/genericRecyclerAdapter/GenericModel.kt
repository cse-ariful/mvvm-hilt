package com.example.mvvmwithhilt.common.genericRecyclerAdapter

abstract class GenericModel {
    var adapterPosition: Int = -1
    var onItemClickEvent: GenericAdapter.OnItemClickEvent? = null
}