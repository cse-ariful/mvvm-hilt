package com.example.mvvmwithhilt

import android.content.Context
import java.io.InputStream

public class AssetProvider(val context: Context){
    fun getAssetStream( name:String): InputStream {
        return context.assets.open(name)
    }
}