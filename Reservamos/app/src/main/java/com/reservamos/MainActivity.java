package com.reservamos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.reservamos.Adapters.LocalesAdapter;
import com.reservamos.Entity.Locales;

import org.java_websocket.client.WebSocketClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private WebSocketClient mWebSocketClient = null;
    private Runnable viewParts = null;
    private LocalesAdapter m_adapter= null;
    private ArrayList<Locales> listaLocales = new ArrayList<Locales>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = (ListView)findViewById(R.id.mainListView);
        Servicio ser = new Servicio();
        listaLocales = ser.GetData();
        m_adapter = new LocalesAdapter(this, listaLocales);
        lv.setAdapter(m_adapter);
    }
}
