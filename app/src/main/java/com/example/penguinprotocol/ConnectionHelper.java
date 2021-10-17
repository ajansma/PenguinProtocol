package com.example.penguinprotocol;

import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.JSONParser;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;


import javax.net.ssl.HttpsURLConnection;

public class ConnectionHelper {
    private static final String TAG = "MainActivity";

    public ConnectionHelper() {

        makeRequest("http://147.222.70.33", "/basic-query", "POST", "{\"sel\": \"*\", \"table\": \"PROGRAM\", \"where\": \"\"}");


    }

        public String makeRequest (String urlName, String endpoint, String method, String payload){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            StringBuilder result = new StringBuilder();
            try {
                URL url = new URL(urlName + endpoint);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod(method);
                urlConnection.setRequestProperty("Content-Type", "application/json");
                DataOutputStream os = new DataOutputStream(urlConnection.getOutputStream());
                byte[] postData = payload.getBytes(StandardCharsets.UTF_8);
                os.write(postData);

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (urlConnection.getInputStream())));
                String output;
                while ((output = br.readLine()) != null) {
                    result.append(output);
                    Log.d("TESTING TAG", output);
                    //Toast.makeText(this, output, Toast.LENGTH_SHORT).show();
                }
                urlConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(result.toString());
            return result.toString();
        }

    public void addReview(String user, String date, String location, String text, String stars, String price) {
        String payload = String.format("{\"user\": \"%s\",\"date\": \"%s\",\"location\": \"%s\",\"text\": \"%s\",\"stars\": \"%s\",\"price\": \"%s\"}", user, date, location, text, stars, price);
        Log.d(TAG, payload);
        makeRequest("http://147.222.70.33", "/add-review", "POST", payload);
    }

}
