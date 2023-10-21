package org.techtales.notificationapp

import android.app.NotificationManager
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

        binding.high.setOnClickListener {
            val notification = NotificationCompat.Builder(this, App().CHANNEL_ID1)
            notification.setContentTitle(binding.title.text.toString())
            notification.setContentText(binding.content.text.toString())
                notification.setSmallIcon(R.drawable.baseline_arrow_upward_24)
                    notification.setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .setColor(Color.MAGENTA)
                        .addAction(R.drawable.baseline_arrow_upward_24,"Back", null)
                        .addAction(R.drawable.baseline_arrow_upward_24,"Play", null)
                        .addAction(R.drawable.baseline_arrow_upward_24,"Next", null)
                        .setOnlyAlertOnce(true)
                        .setAutoCancel(true)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(1, notification.build())
        }

        binding.low.setOnClickListener{

            val notification = NotificationCompat.Builder(this, App().CHANNEL_ID2)
            notification.setContentTitle(binding.title.text.toString())
            notification.setContentText(binding.content.text.toString())
                notification.setSmallIcon(R.drawable.baseline_arrow_downward_24)
            notification.setPriority(NotificationCompat.PRIORITY_LOW)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(2, notification.build())

        }
    }
}