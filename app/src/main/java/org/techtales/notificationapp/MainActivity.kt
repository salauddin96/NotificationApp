package org.techtales.notificationapp

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import org.techtales.notificationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this@MainActivity, MainActivity::class.java)
        val intentNext = Intent(this@MainActivity, NextActivity::class.java)
        val intentPlay = Intent(this@MainActivity, PlayActivity::class.java)
        val intentBack = Intent(this@MainActivity, BackActivity::class.java)


        binding.highBtn.setOnClickListener {
            val notification = NotificationCompat.Builder(this, App().CHANNEL_ID1)
            notification.setContentTitle(binding.titleEtxt.text.toString())
            notification.setContentText(binding.desEtxt.text.toString())

            intent.putExtra("Data", binding.desEtxt.text.toString())
            intentNext.putExtra("Data_next",  "This is the text being passed to the next activity.")
            intentPlay.putExtra("Data_play", binding.desEtxt.text.toString())
            intentBack.putExtra("Data_back", binding.desEtxt.text.toString())

            val pendingIntent = PendingIntent.getActivity(this@MainActivity, 0, intent, PendingIntent.FLAG_MUTABLE)
            val NextIntent = PendingIntent.getActivity(this@MainActivity, 0, intentNext, PendingIntent.FLAG_MUTABLE)
            val PlayIntent = PendingIntent.getActivity(this@MainActivity, 0, intentPlay, PendingIntent.FLAG_MUTABLE)
            val BackIntent = PendingIntent.getActivity(this@MainActivity, 0, intentBack, PendingIntent.FLAG_MUTABLE)

            notification.setSmallIcon(R.drawable.baseline_arrow_upward_24)
            notification.setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.MAGENTA)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.baseline_arrow_upward_24,"Back", BackIntent)
                .addAction(R.drawable.baseline_arrow_upward_24,"Play", PlayIntent)
                .addAction(R.drawable.baseline_arrow_upward_24,"Next", NextIntent)
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(1, notification.build())
        }

        binding.lowBtn.setOnClickListener{

            val notification = NotificationCompat.Builder(this, App().CHANNEL_ID2)
            notification.setContentTitle(binding.titleEtxt.text.toString())
            notification.setContentText(binding.desEtxt.text.toString())
            notification.setSmallIcon(R.drawable.baseline_arrow_downward_24)
            notification.setPriority(NotificationCompat.PRIORITY_LOW)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(2, notification.build())

        }
    }
    }