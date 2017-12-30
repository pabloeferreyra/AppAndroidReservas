package com.pabloeferreyra.reservamos

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
/**
 * Created by pablo on 23/12/2017.
 */
 open class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent (
                this,
                MainActivity ::class.java
        )
        startActivity(intent)
        finish()
    }
}
