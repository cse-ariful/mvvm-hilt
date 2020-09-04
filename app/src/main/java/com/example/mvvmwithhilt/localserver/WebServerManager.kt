package com.example.mvvmwithhilt.localserver

import android.util.Log
import fi.iki.elonen.NanoHTTPD

class WebServerManager( hostIp:String?,  port:Int) : NanoHTTPD(hostIp,port){
    public interface Listener{
        fun onStart();
        fun onStop();
        fun onRequestResponse(
            params: MutableMap<String, String>,
            requestType: Method?,
            submissionIp: String
        ):String?
    }
    var listener:Listener?=null

    override fun serve(session: IHTTPSession?): Response {
         Log.d("serve", "serve: "+session?.parms)
         Log.d("serve", "serve: "+session?.headers)
        val submissionIp = session?.headers?.get("remote-addr")?:"not found";
        val response = listener?.onRequestResponse(session?.parms?: mutableMapOf(),session?.method?:null,submissionIp)

        return Response(response)
    }
    init {

    }
    override fun start() {
        super.start()
        listener?.onStart()

    }

    override fun stop() {
        super.stop()
        listener?.onStop()
    }

    override fun closeAllConnections() {
        super.closeAllConnections()
    }

    companion object{
        fun getInstance(hostIp:String,port:Int): WebServerManager {
            return WebServerManager(hostIp = hostIp,port = port)
        }
    }
}