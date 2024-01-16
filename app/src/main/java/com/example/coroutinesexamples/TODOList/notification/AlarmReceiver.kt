package com.example.coroutinesexamples.TODOList.notification

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationManager
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.coroutinesexamples.TODOList.Database.ToDoListDatabase
import java.util.Date

class AlarmReceiver : BroadcastReceiver() {
private val GROUP_MESSAGE : String = "TODOList"

    var toDoListDatabse: ToDoListDatabase? = null
    @SuppressLint("WrongConstant")
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let{ initiateDatabase(it)}
        val notificationManager: NotificationManager =context?.getSystemService(Service.NOTIFICATION_SERVICE) as NotificationManager
        val isShow =intent?.getIntExtra("isShow",0)?:0

    }

    private fun initiateDatabase(context: Context?){
        if (toDoListDatabse == null){
            toDoListDatabse = ToDoListDatabase.getInstance(context!!)
        }
    }
fun getNumber() : Int = (Date().time/1000L % Integer.MAX_VALUE).toInt()
}