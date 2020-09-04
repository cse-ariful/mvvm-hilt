package com.example.mvvmwithhilt.ui.wifip2p

import android.Manifest
import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.wifi.WpsInfo
import android.net.wifi.p2p.WifiP2pConfig
import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pManager
import android.net.wifi.p2p.WifiP2pManager.*
import android.util.Log
import androidx.core.app.ActivityCompat

class WifiBroadCastReciever(
    val manager: WifiP2pManager,
    val channel: Channel,
    val context: Context
) : BroadcastReceiver() {

    private val peers = mutableListOf<WifiP2pDevice>()
    private val peerListListener:PeerListListener;
    init {
        peerListListener = PeerListListener { peerlist->
            val refreshedPeers = peerlist.deviceList
            if (refreshedPeers != peers) {
                peers.clear()
                peers.addAll(refreshedPeers)
                Log.d("WifiP2p", "New Device Found ${peerlist.deviceList.size}")
            }
            if (peers.isEmpty()) {
                Log.d("WifiP2p", "No devices found")
                return@PeerListListener
            }
        }
    }
    @SuppressLint("MissingPermission")
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("WifiP2p", "onReceive: "+intent.action)
        when(intent.action){
            WIFI_P2P_STATE_CHANGED_ACTION -> {
                manager.requestPeers(this.channel,peerListListener)
            }
            WIFI_P2P_PEERS_CHANGED_ACTION -> {

            }
            WIFI_P2P_CONNECTION_CHANGED_ACTION -> {

            }
            WIFI_P2P_THIS_DEVICE_CHANGED_ACTION ->{

        }
        }
    }

}