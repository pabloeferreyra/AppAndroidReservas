package io.github.pabloeferreyra.reservamos

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import org.java_websocket.client.WebSocketClient

class MainActivity : AppCompatActivity() {

    private val mWebSocketClient: WebSocketClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ser: Servicio = Servicio()

        var json = ser.getData()

    }



    fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()
    }
}
