package com.example.penguinprotocol;

//import org.json.simple.JSONObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AppController {
    private ArrayList<Program> programList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Review> reviewList = new ArrayList<>();
    private ArrayList<Location> locationList = new ArrayList<>();
    private DatabaseHandler handler = new DatabaseHandler();
    private static AppController single_instance = null;
    private ConnectionHelper connection = new ConnectionHelper();

    public AppController(){
        //gets a json arraylist from the database class
        String jsonString = connection.makeRequest("http://147.222.70.33","/basic-query", "POST", "{\"sel\": \"*\", \"table\": \"PROGRAM\", \"where\": \"\"}");
        try {
            JSONObject jsonObj = new JSONObject(jsonString);
            JSONArray rows = jsonObj.getJSONArray("rows");
            for(int i = 0; i < rows.length(); i++) {
                JSONObject firstRowItem = rows.getJSONObject(i);
                programList.add(new Program(firstRowItem));
                System.out.println(programList.get(0).getProgramName());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //Method to make AppController a singleton
    public static AppController getInstance() {
        if (single_instance == null) {
            single_instance = new AppController();
        }
        return single_instance;
    }

    public ArrayList<Location> getLocations(String country){
        String jsonString = connection.makeRequest("http://147.222.70.33","/basic-query", "POST", "{\"sel\": \"*\", \"table\": \"LOCATION\", \"where\": \"" + country + "\"");
        try {
            JSONObject jsonObj = new JSONObject(jsonString);
            JSONArray rows = jsonObj.getJSONArray("rows");
            for(int i = 0; i < rows.length(); i++) {
                JSONObject firstRowItem = rows.getJSONObject(i);
                locationList.add(new Location(firstRowItem));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < locationList.size(); i++){
            System.out.println(locationList.get(i).getCity());
        }
        return locationList;

    }

    public ArrayList<Program> getProgramList() {
        return programList;

    }

    public void setProgramList(ArrayList<Program> programList) {
        this.programList = programList;

    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(ArrayList<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public ArrayList<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(ArrayList<Location> locationList) {
        this.locationList = locationList;
    }

    public DatabaseHandler getHandler() {
        return handler;
    }

    public void setHandler(DatabaseHandler handler) {
        this.handler = handler;

    }


}
