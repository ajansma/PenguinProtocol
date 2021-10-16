package com.example.penguinprotocol;

import android.util.Log;

import org.json.JSONTokener;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class ConnectionHelper {
    private static final String TAG = "MainActivity";

    //147.222.70.33
    private String databaseURL = "147.222.70.33/get-table-names";

    public ConnectionHelper() throws Exception{
        URL url = new URL("http://147.222.70.33/");
        Object newobj = url.getContent();
        HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
        Log.d(TAG, "SUCCESS");
        //conn.setRequestMethod("GET");
        //conn.connect();

        /*
        InputStream is = new URL(databaseURL).openStream();
        Log.d(TAG, "Success");
        is.close();

         */
    }
}
