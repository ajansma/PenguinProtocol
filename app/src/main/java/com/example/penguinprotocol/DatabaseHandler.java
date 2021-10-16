package com.example.penguinprotocol;

import org.json.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class DatabaseHandler {
    private JSONObject jsonObj = new JSONObject();
    private String IPAdress = "";

    public DatabaseHandler(){
        jsonObj.put("Database name", "name");
    }

    public void addObject(String entry, String data){
        jsonObj.put(entry, data);
    }

    public void sendPost(JSONObject obj){
        String jsonString = obj.toJSONString();
        sendData(jsonString);
    }

    public void sendData(String toSend){
        HttpsURLConnection connection = null;

    }

    public ArrayList<JSONObject> pullJSONArray(String databaseToPull){
        ArrayList<JSONObject> jsonArray = new ArrayList<JSONObject>();

        return jsonArray;
    }
}
