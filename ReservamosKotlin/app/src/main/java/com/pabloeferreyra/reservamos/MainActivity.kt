package com.pabloeferreyra.reservamos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pabloeferreyra.reservamos.R.id.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doAsync  {
            val result = URL("http://192.168.1.11:8081/locales").readText()
            uiThread {
                Log.d("Request", result.toString())
                longToast("Request performed")
            }
        }

    }
}
