package com.bytestore.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bytestore.app.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

    }
}