package com.taurunium.coroutinessecondapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.taurunium.coroutinessecondapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        sayHelloFromMain()
        sayHelloFromBackground()
    }

    private fun sayHelloFromMain(){
        CoroutineScope(Dispatchers.Main).launch {
            binding.text1.text = "Hello from Main"
        }
    }

    private fun sayHelloFromBackground(){
        CoroutineScope(Dispatchers.IO).launch {
            binding.text2.text = "Hello from Main"
        }
    }
}