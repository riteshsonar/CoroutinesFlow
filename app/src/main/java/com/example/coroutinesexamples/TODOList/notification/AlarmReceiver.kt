package com.example.coroutinesexamples.TODOList.notification

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.coroutinesexamples.R
import com.example.coroutinesexamples.TODOList.Database.ToDoListDatabase
import java.util.Date

class AlarmReceiver : BroadcastReceiver() {
private val GROUP_MESSAGE : String = "TODOList"
    companion object{
        private val  TAG : String = "AlarmReceiver"

    }

    var toDoListDatabse: ToDoListDatabase? = null
    @SuppressLint("WrongConstant", "NotificationPermission")
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let{ initiateDatabase(it)}
        val notificationManager: NotificationManager =context?.getSystemService(Service.NOTIFICATION_SERVICE) as NotificationManager
        val isShow =intent?.getIntExtra("isShow",0)?:0
        val dbId = intent?.getLongExtra("id",-1)?: -1
        val title = intent?.getStringExtra("title")?: ""
        val time = intent?.getStringExtra("date")?: ""
        Log.d(TAG,"Title $title")
        val icon = R.drawable.ic_launcher_foreground
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val notificationChannel =NotificationChannel("Remainder","My Notifications", NotificationManager.IMPORTANCE_MAX)
                //configuration the channel
            notificationChannel.description = "Sample Channel description"
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.BLUE
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val notification = NotificationCompat.Builder(context,"Remainder")
            .setSmallIcon(icon)
            .setContentTitle(title)
            .setContentText(time)
            .setPriority(NotificationCompat.VISIBILITY_PUBLIC)
            .setColor(Color.RED)
            .setGroup(GROUP_MESSAGE)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .build()
        notificationManager.notify(getNumber(),notification)

        toDoListDatabse?.toDoListDao()?.isShowUpdate(id = dbId,isShow=1)
        val list =toDoListDatabse?.toDoListDao()?.get(dbId)
        Log.d(TAG," isRead ${list?.isShow}")

    }

    private fun initiateDatabase(context: Context?){
        if (toDoListDatabse == null){
            toDoListDatabse = ToDoListDatabase.getInstance(context!!)
        }
    }
fun getNumber() : Int = (Date().time/1000L % Integer.MAX_VALUE).toInt()
}