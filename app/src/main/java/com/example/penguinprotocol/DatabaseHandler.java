package com.example.penguinprotocol;

import org.json.simple.JSONObject;

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

    public void sendPost(){
        String jsonString = jsonObj.toJSONString();
        sendData();
    }

    public void sendData(){
        HttpsURLConnection connection = null;

    }

    public String pullJSONObject(String databaseToPull){
        return "jsonObj";
    }
}
