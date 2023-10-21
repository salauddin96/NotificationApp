package org.techtales.notificationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtales.notificationapp.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityPlayBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textView4.text = intent.getStringExtra("Data_play")
    }
}