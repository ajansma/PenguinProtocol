package com.example.penguinprotocol;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class AppController {
    private ArrayList<Program> programList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Review> reviewList = new ArrayList<>();
    private DatabaseHandler handler = new DatabaseHandler();

    public AppController() throws ParseException {
        Object obj = new JSONParser().parse(handler.pullJSONObject("Program"));
    }

}
