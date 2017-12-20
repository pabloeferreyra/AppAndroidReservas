package io.github.pabloeferreyra.reservamos;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIMEOUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIMEOUT);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                URL githubEndpoint = null;
                HttpsURLConnection myConnection = null;
                try {
                    githubEndpoint = new URL("https://api.github.com/");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    myConnection =
                            (HttpsURLConnection) githubEndpoint.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                myConnection.setRequestProperty("User-Agent", "my-rest-app-v0.1");
                try {
                    if (myConnection.getResponseCode() == 200) {
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader =
                                new InputStreamReader(responseBody, "UTF-8");
                    } else {
                        // Error handling code goes here
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
