package io.github.pabloeferreyra.reservamos

import android.os.StrictMode
import io.github.pabloeferreyra.reservamos.Entity.Locales
import org.json.JSONArray
import org.json.JSONException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

/**
 * Created by pablo on 24/12/2017.
 */
class Servicio {

     fun getData() : ArrayList<Locales?> {
        var jsonArr: JSONArray? = null
        var locales : ArrayList<Locales?> = ArrayList<Locales?>()
        val dir = "http://192.168.1.6:8081/locales"
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var url: URL? = null
        val conn: HttpURLConnection
        try {
            url = URL(dir)
            conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.connect()

            val ent = BufferedReader(InputStreamReader(conn.inputStream))

            var inputLine: String?

            val response = StringBuffer()

            var json = ""

            do {
                inputLine = ent.readLine()
                response.append(inputLine)
                if (inputLine == null)
                    break;
            }while(inputLine != null)

            json = response.toString()

            jsonArr = JSONArray(json)

            for (i in 0..jsonArr.length()) {
                val JsonObject = jsonArr.getJSONObject(i)
                var locales1 : Locales = Locales()
                locales1.Nombre = JsonObject.optString("Nombre")
                locales1.Direccion = JsonObject.optString("Direccion")
                locales1.Valuacion = JsonObject.optInt("Valuacion")
                locales.add(locales1)
            }

        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return locales
    }

}