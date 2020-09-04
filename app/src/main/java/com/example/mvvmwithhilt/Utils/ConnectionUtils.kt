package com.example.mvvmwithhilt.Utils

import android.content.Context
import android.location.LocationManager
import android.net.wifi.WifiManager
import javax.inject.Inject

class ConnectionUtils @Inject constructor(val context: Context) {
    val wifiManager:WifiManager
    val locationManager:LocationManager
    init {
        wifiManager = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        locationManager = context.applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    }

}