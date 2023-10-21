package org.techtales.notificationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtales.notificationapp.databinding.ActivitySecondBinding

class Second : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textView.text = intent.getStringExtra("Data")
    }
}