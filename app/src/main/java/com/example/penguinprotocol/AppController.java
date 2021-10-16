package com.example.penguinprotocol;

import org.json.simple.JSONObject;
import java.util.ArrayList;


public class AppController {
    private ArrayList<Program> programList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Review> reviewList = new ArrayList<>();
    private DatabaseHandler handler = new DatabaseHandler();

    public AppController(){
        //gets a json arraylist from the database class
        ArrayList<JSONObject> jsonArray = handler.pullJSONArray("program");
        for(JSONObject object : jsonArray){
            programList.add(new Program(object));
        }
        //gets an arraylist of reviews from the database class
        ArrayList<JSONObject> jsonArray2 = handler.pullJSONArray("review");
        for(JSONObject object : jsonArray2){
            reviewList.add(new Review(object));
        }
        //gets an arraylist of users from the database class
        ArrayList<JSONObject> jsonUserArray = handler.pullJSONArray("user");
        for(JSONObject object : jsonUserArray){
            userList.add(new User(object));
        }
    }
}
