package com.example.mvvmwithhilt.model

import com.google.gson.annotations.SerializedName

data class AttendanceModel(
    @SerializedName("studentId")
    var studentId:String,
    @SerializedName("studentName")
    var studentName:String,
    @SerializedName("submitIP")
    var submitIp:String,
    var accepTed:Boolean=true
)