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

        val intent = Intent(this@MainActivity, Second::class.java)

        binding.high.setOnClickListener {
            val notification = NotificationCompat.Builder(this, App().CHANNEL_ID1)
            notification.setContentTitle(binding.title.text.toString())
            notification.setContentText(binding.content.text.toString())

            intent.putExtra("Data", binding.content.text.toString())

            val pendingIntent = PendingIntent.getActivity(this@MainActivity, 0, intent, PendingIntent.FLAG_MUTABLE)

                notification.setSmallIcon(R.drawable.baseline_arrow_upward_24)
                    notification.setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .setColor(Color.MAGENTA)
                        .setContentIntent(pendingIntent)
                        .addAction(R.drawable.baseline_arrow_upward_24,"Back", pendingIntent)
                        .addAction(R.drawable.baseline_arrow_upward_24,"Play", pendingIntent)
                        .addAction(R.drawable.baseline_arrow_upward_24,"Next", pendingIntent)
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