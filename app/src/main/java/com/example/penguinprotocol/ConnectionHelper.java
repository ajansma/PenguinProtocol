package com.example.penguinprotocol;

import android.os.StrictMode;
import android.util.Log;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.JSONParser;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import javax.net.ssl.HttpsURLConnection;

public class ConnectionHelper {
    private static final String TAG = "MainActivity";

    public ConnectionHelper() throws Exception {
        //bypass security issues
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            //create the request url and open the url
            String payload = "{\"sel\": \"*\" \"table\": \"PROGRAM\" \"where\": \"\"}";

            URL url = new URL("http://147.222.70.33/basic-query");

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setDoInput(true);
            OutputStream os = urlConnection.getOutputStream();
            byte[] input = payload.getBytes();
            os.write(input);
            os.flush();


            // get the json response
            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);

            String result = "";
            int data = reader.read();
            while (data != -1) {
                result += (char) data;
                data = reader.read();
            }
            System.out.println("RESULT" + result);
            // parse the response for the data you are looking for
            JSONArray jsonArray = new JSONArray(result);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
