package com.example.penguinprotocol;

import org.json.simple.JSONObject;
import java.util.ArrayList;


public class AppController {
    private ArrayList<Program> programList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Review> reviewList = new ArrayList<>();
    private ArrayList<Location> locationList = new ArrayList<>();
    private DatabaseHandler handler = new DatabaseHandler();

    public AppController(){
        System.out.println("HELLO FROM APP CONTROLLER");
        //gets a json arraylist from the database class
        ArrayList<JSONObject> jsonArray = handler.pullJSONArray("PROGRAM");
        for(JSONObject object : jsonArray){
            programList.add(new Program(object));
        }
    }


}
