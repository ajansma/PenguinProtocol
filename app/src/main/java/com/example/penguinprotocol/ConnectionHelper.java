package com.example.penguinprotocol;

import android.os.StrictMode;
import android.util.Log;

import org.json.JSONTokener;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class ConnectionHelper {
    private static final String TAG = "MainActivity";

    //147.222.70.33
    private String databaseURL = "147.222.70.33/get-table-names";

    public ConnectionHelper() throws Exception {
        //bypass security issues
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            //create the request url and open the url
            URL url = new URL("http://147.222.70.33/get-table-names");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            // get the json response
            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);

            String result = "";
            int data = reader.read();
            while (data != -1) {
                result += (char) data;
                System.out.println("RESULT progress: " + result);
                data = reader.read();
            }
            System.out.println("RESULT" + result);
            // parse the response for the data you are looking for
            JSONObject jsonObject = new JSONObject();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
