package com.example.penguinprotocol;

import org.json.simple.JSONObject;
import java.util.ArrayList;


public class AppController {
    private ArrayList<Program> programList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Review> reviewList = new ArrayList<>();
    private ArrayList<Location> locationList = new ArrayList<>();
    private DatabaseHandler handler = new DatabaseHandler();
    private static AppController single_instance = null;

    public AppController(){
        System.out.println("HELLO FROM APP CONTROLLER");
        //gets a json arraylist from the database class
        ArrayList<JSONObject> jsonArray = handler.pullJSONArray("PROGRAM");
        for(JSONObject object : jsonArray){
            programList.add(new Program(object));
        }
        //gets an arraylist of reviews from the database class
        ArrayList<JSONObject> jsonArray2 = handler.pullJSONArray("REVIEW");
        for(JSONObject object : jsonArray2){
            reviewList.add(new Review(object));
        }
        //gets an arraylist of users from the database class
        ArrayList<JSONObject> jsonUserArray = handler.pullJSONArray("USER");
        for(JSONObject object : jsonUserArray){
            userList.add(new User(object));
        }
        ArrayList<JSONObject> jsonUserArray3 = handler.pullJSONArray("USER");
        for(JSONObject object : jsonUserArray3){
            locationList.add(new Location(object));
        }


    }

    //Method to make AppController a singleton
    public static AppController getInstance() {
        if (single_instance == null) {
            single_instance = new AppController();
        }
        return single_instance;
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
