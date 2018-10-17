package com.morty.rick.rickmorty.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import com.morty.rick.rickmorty.R
import com.morty.rick.rickmorty.ui.base.BaseActivity
import com.morty.rick.rickmorty.ui.main.MainActivity


/**
 * Created by Akash Verma on 05/09/18.
 */
private const val SPLASH_TIMEOUT = 1000L

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        Glide.with(this).load(R.drawable.splash)
                .into(findViewById(R.id.iv_splash))

        Handler().postDelayed({
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIMEOUT)

    }
}