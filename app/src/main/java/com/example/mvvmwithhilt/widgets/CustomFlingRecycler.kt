package com.example.mvvmwithhilt.widgets

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

class CustomFlingRecycler:RecyclerView{
    val FLING_SPEED_FACTOR  = 1
    constructor( context: Context) : super(context)
    constructor( context: Context, attrs:AttributeSet) : super(context,attrs)
    constructor( context: Context, attrs:AttributeSet,theme:Int) : super(context,attrs,theme)

    override fun fling(velocityX: Int, velocityY: Int): Boolean {

        // if FLING_SPEED_FACTOR between [0, 1[ => slowdown
        var velocityY = velocityY
        velocityY = (velocityY* this.FLING_SPEED_FACTOR).toInt()
        return super.fling(velocityX, velocityY)
    }
}