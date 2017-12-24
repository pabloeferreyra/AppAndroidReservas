package io.github.pabloeferreyra.reservamos

import android.os.StrictMode
import io.github.pabloeferreyra.reservamos.entity.Locales
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.reflect.Array
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.*

/**
 * Created by pablo on 24/12/2017.
 */
class Servicio {

     fun getData() : JSONArray? {
        var jsonArr: JSONArray? = null
         var locales : Arrays
        val dir = "http://192.168.1.11:8081/locales"
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

            }

        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return jsonArr
    }

}