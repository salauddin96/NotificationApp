package org.techtales.notificationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtales.notificationapp.databinding.ActivityBackBinding

class BackActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBackBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityBackBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textView3.text = intent.getStringExtra("Data_back")
    }
}