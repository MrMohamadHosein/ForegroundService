package ir.MrMohamadHosein.foregroundService

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class LogcatService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground( 1001 , createNotification() )

        Thread.sleep(15000)
        stopSelf()

        return START_STICKY
    }
    override fun onCreate() {
        super.onCreate()
    }
    override fun onDestroy() {
        stopForeground(true)
        super.onDestroy()
    }
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    private fun doYourJob() {

        for (i in 0..1000000) {
            Log.v("testMyService" , "number $i")
        }

    }

    private fun createNotification() :Notification {

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel("myChannel" , "my app channel" , NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val notification = NotificationCompat.Builder(this , "myChannel")
            .setSmallIcon( android.R.drawable.stat_notify_chat )
            .setContentTitle("service is running ....")
            .setContentText("don't worry :) ")
            .build()

        return notification
    }

}