package com.example.mvvmwithhilt.ui.host

import android.content.Context
import android.net.wifi.WifiManager
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.mvvmwithhilt.AssetProvider
import com.example.mvvmwithhilt.Courotines
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.localserver.IpResolver
import com.example.mvvmwithhilt.localserver.WebServerManager
import com.example.mvvmwithhilt.model.AttendanceModel
import com.example.mvvmwithhilt.utility.Const
import fi.iki.elonen.NanoHTTPD
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.io.InputStream

public class HostViewModel @ViewModelInject constructor(assetProvider: AssetProvider) : ViewModel(), WebServerManager.Listener {
    val data = MutableLiveData<HashMap<String, String>>()
    val submittedList = MutableLiveData<ArrayList<AttendanceModel>>(ArrayList())
    val hostAddress = MutableLiveData<String>()
    val webServerStatue  =MutableLiveData<String>("Not started")
    val running = MutableLiveData<Boolean>(false)
    var webServer:WebServerManager? = null
    var formString:String
    var successString:String
    var errorString:String
    var ipAddress:String? = null
    init {
        formString=getAssetasString( assetProvider.getAssetStream("attendanceform.html"))
        successString = getAssetasString(assetProvider.getAssetStream("success.html"))
        errorString = getAssetasString(assetProvider.getAssetStream("error.html"))

    }

    private fun getAssetasString(istream: InputStream): String  {
        try {
            val size = istream.available()
            val buffer = ByteArray(size)
            istream.read(buffer)
            istream.close()
            return String(buffer)
        }catch (e:IOException){
            return "<h1>Something went wrong</h1><br><h3>error Code READ_FAILED"
        }
    }

      fun toggleLocalServer(){
        Courotines.ioThenMain(
            {
                ipAddress = IpResolver.getIPAddress(true)
                if(webServer==null){
                    webServer =  WebServerManager(ipAddress,Const.LOCAL_SERVER_PORT);
                }
                webServer?.let {
                    if(it.isAlive){
                        it.closeAllConnections()
                        it.stop()
                        it.listener=null;
                    }else{
                        it.listener=this@HostViewModel
                        it.start()
                    }
                }
            },
            {
                //if any value returned this will be from here
            }
        )

    }

    private fun getIpAddress(context: Context): String {
        val wifiManager = context.getApplicationContext().getSystemService(Context.WIFI_SERVICE) as WifiManager
        val ipAddress = wifiManager.connectionInfo.ipAddress
        return String.format(
            "%d.%d.%d.%d", ipAddress and 0xff,
            ipAddress shr 8 and 0xff,
            ipAddress shr 16 and 0xff, ipAddress shr 24 and 0xff
        )
    }

    override fun onStart() {
        webServerStatue.postValue("Started server")
        hostAddress.postValue(ipAddress+":"+webServer?.listeningPort)
        Log.d(TAG, "onStart: "+webServer?.listeningPort)
        running.postValue(true)
    }

    override fun onStop() {
        webServerStatue.postValue("Stopped")
        hostAddress.postValue("Disconnected")
        Log.d(TAG, "onStop: "+webServer?.listeningPort)
        running.postValue(false)
    }
    override fun onRequestResponse(
        params: MutableMap<String, String>,
        requestType: NanoHTTPD.Method?,
        submissionIp: String
    ): String? {
        val id=params.get("studentId")
        val name = params.get("studentName")
        if(name!=null && id!=null){
            val list = submittedList.value
            list?.forEach {
                if(it.submitIp==submissionIp){
                    return getErroPage("Your are not allowed to submit multiple time")
                }
            }
            list?.add(AttendanceModel(id,name,submissionIp,false))
            submittedList.postValue(list)
            return successString
        }
        return formString
    }

    private fun getErroPage(message: String): String? {
        return errorString.replace("ERROR_MESSAGE",message)
    }

    override fun onCleared() {
        super.onCleared()
        if(webServer!=null && webServer!!.isAlive){
            webServer!!.stop()
        }
    }

    companion object{
        final val TAG = "HOSTVIEWMODEL";
    }
}
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, running: Boolean)   {
    Log.d("ariful", "loadImage() called with: view = $view, running = $running")
    running.let {
        if(running) Glide.with(view.context).load(R.drawable.loading).placeholder(R.drawable.loading).into(view)
    }
}