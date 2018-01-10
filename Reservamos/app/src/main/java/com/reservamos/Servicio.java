package com.reservamos;

import android.os.StrictMode;

import com.reservamos.Entity.Locales;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by pablo on 3/1/2018.
 */

public class Servicio {

    public ArrayList<Locales> GetData(){
        JSONArray JsonArr = null;
        ArrayList<Locales> locales = new ArrayList<Locales>();
        String dir = "http://192.168.0.4:8081/locales";
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url;
        HttpURLConnection connection;
        try
        {
            url = new URL(dir);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            BufferedReader ent = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            StringBuffer response = new StringBuffer();
            String json = "";
            while((line = ent.readLine()) != null)
            {
                response.append(line);
            }
            json = response.toString();
            JsonArr = new JSONArray(json);
            for (int i= 0; i<JsonArr.length();i++ ){
                JSONObject JsonObject = JsonArr.getJSONObject(i);
                Locales locales1 = new Locales();
                locales1.ID = JsonObject.optInt("ID");
                locales1.Nombre = JsonObject.optString("Nombre");
                locales1.Direccion = JsonObject.optString("Direccion");
                locales1.Valuacion = JsonObject.optInt("Valuacion");
                locales1.Imagen = JsonObject.optString("Imagen");
                locales.add(locales1);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return locales;
    }
}
