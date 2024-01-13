package com.example.coroutinesexamples.TODOList.notification

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationManager
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver() {
private val GROUP_MESSAGE : String = "TODOList"

    @SuppressLint("WrongConstant")
    override fun onReceive(context: Context?, intent: Intent?) {
        //context?.let{ initiateDatabase(it)}
        val notificationManager: NotificationManager =context?.getSystemService(Service.NOTIFICATION_SERVICE) as NotificationManager
        val isShow =intent?.getIntExtra("isShow",0)?:0
    }
}