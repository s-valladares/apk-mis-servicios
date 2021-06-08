package com.soluciones.misservicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.soluciones.misservicios.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        setAnimation()
    }

    private fun setAnimation(){
        binding.img.animate().translationY(-4000f).setDuration(1000).startDelay = 5000
        binding.logo.animate().translationY(3000f).setDuration(1000).startDelay = 5000
        binding.appName.animate().translationY(3000f).setDuration(1000).startDelay = 5000
        binding.lottie.animate().translationY(3000f).setDuration(1000).startDelay = 5000
    }
}