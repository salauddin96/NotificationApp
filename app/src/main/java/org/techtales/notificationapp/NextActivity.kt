package org.techtales.notificationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtales.notificationapp.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNextBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityNextBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textViewNext.setText(intent.getStringExtra("Data_next"))
    }
}