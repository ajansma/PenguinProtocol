package com.example.penguinprotocol;

import org.json.simple.JSONObject;

//import org.json.JSONObject;

public class Review {
    private int review_id;
    private int user;
    private int date;
    private int location;
    private String text;
    private int stars;
    private int price;

    public Review() {
        //user = new User();
    }

    public Review(int user, int date, int location, String text, int stars, int price) {
       this.user = user;
       this.date = date;
       this.location = location;
       this.text = text;
       this.stars = stars;
       this.price = price;

    }

    public Review(JSONObject obj){
        /*
        date = obj.getString("date");
        location = (int)(obj.get("location"));
        text = obj.get("text").toString();
        stars = (int)(obj.get("stars"));
        price = (int)(obj.get("price"));

         */
    }

    public JSONObject toJSON(){
        JSONObject obj = new JSONObject();
        obj.put("date", date);
        obj.put("location", location);
        obj.put("text", text);
        obj.put("stars", stars);
        obj.put("price", price);
        return obj;
    }

    /**
     * Getters and Setters:
     */
    public int getUser() {
        return user;
    }

    public int getEntryDate() {
        return date;
    }

}
