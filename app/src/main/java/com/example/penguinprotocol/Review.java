package com.example.penguinprotocol;

//import org.json.simple.JSONObject;

import org.json.JSONObject;

public class Review {
    private String review_id;
    private String user;
    private String date;
    private String location;
    private String text;
    private String stars;
    private String price;

    public Review() {
        //user = new User();
    }

    public Review(JSONObject obj){
        try {
            date = obj.getString("date");
            location = (obj.getString("location"));
            text = obj.getString("text");
            stars = obj.getString("stars");
            price = obj.getString("price");
        }
        catch(Exception e){
            System.out.println("FAIL");
        }


    }


    /**
     * Getters and Setters:
     */
    public String getUser() {
        return user;
    }

    public String getEntryDate() {
        return date;
    }

    public String getLocation(){
        return location;
    }

}
