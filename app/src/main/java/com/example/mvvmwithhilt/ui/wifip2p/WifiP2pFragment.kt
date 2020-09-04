package com.example.mvvmwithhilt.ui.wifip2p

import android.Manifest
import android.content.Context
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.p2p.WifiP2pManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.databinding.WifiP2pFragmentBinding

class WifiP2pFragment : Fragment() {

    companion object {
        fun newInstance() = WifiP2pFragment()
    }

    private lateinit var binding: WifiP2pFragmentBinding
    private lateinit var reciever: WifiBroadCastReciever
    private lateinit var channel: WifiP2pManager.Channel
    private lateinit var manager: WifiP2pManager
    val intentFilter = IntentFilter()
    val viewModel by viewModels<WifiP2pViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        manager = requireActivity().getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager
        channel = manager.initialize(requireContext(), requireActivity().mainLooper, null)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.wifi_p2p_fragment,container,false)
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION)
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION)
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION)
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION)
        Glide.with(requireContext()).load(R.drawable.panda_seeting).into(binding.pandImage)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        binding.discover.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(requireActivity(),  arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),120)

            }
            manager.discoverPeers(channel,object:WifiP2pManager.ActionListener{
                override fun onSuccess() {
                    Log.d("WifiP2p", "onSuccess: ")
                }

                override fun onFailure(p0: Int) {
                    Log.d("WifiP2p", "onFailure: ")
                }
            })
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        reciever = WifiBroadCastReciever(manager,channel,requireContext())
        requireActivity().registerReceiver(reciever,intentFilter)
    }

    override fun onStop() {
        super.onStop()
        requireActivity().unregisterReceiver(reciever)
    }

}