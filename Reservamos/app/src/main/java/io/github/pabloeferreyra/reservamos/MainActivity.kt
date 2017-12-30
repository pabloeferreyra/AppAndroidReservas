package io.github.pabloeferreyra.reservamos

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import android.widget.Toast
import io.github.pabloeferreyra.reservamos.Adapters.LocalesAdapter
import io.github.pabloeferreyra.reservamos.Entity.Locales

import org.java_websocket.client.WebSocketClient

class MainActivity : AppCompatActivity() {

    private var mWebSocketClient: WebSocketClient? = null
    private var viewParts: Runnable? = null
    private var m_adapter: LocalesAdapter? = null
    private var listaLocales : ArrayList<Locales?> = ArrayList<Locales?>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lv: ListView = findViewById(R.id.mainListView)
        val ser: Servicio = Servicio()
        listaLocales = ser.getData()
        m_adapter = LocalesAdapter(this, listaLocales)
        lv.adapter = m_adapter
    }



    fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()
    }
}
