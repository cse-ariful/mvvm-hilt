package com.example.mvvmwithhilt.ui.host

import android.net.wifi.p2p.WifiP2pManager
import android.util.Log

class HostRepositories {
    fun searchDevices(){
        /* Callback includes:
    * fullDomain: full domain name: e.g "printer._ipp._tcp.local."
    * record: TXT record dta as a map of key/value pairs.
    * device: The device running the advertised service.
    */
        val txtListener = WifiP2pManager.DnsSdTxtRecordListener { fullDomain, record, device ->
            Log.d("HostSearch", "DnsSdTxtRecord available -$record")
            record["buddyname"]?.also {
                //buddies[device.deviceAddress] = it
            }
        }
    }
}