package com.example.penguinprotocol;

import org.json.simple.JSONObject;

public class Location {
    public String name;
    public String address;
    public String city;
    public String country;
    public int location_id;

    public Location(String name, String address, String city, String country){
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    public Location(JSONObject obj){
        name = obj.get("name").toString();
        address = obj.get("address").toString();
        city = obj.get("city").toString();
        country = obj.get("country").toString();
        location_id = (int)( obj.get("lid"));
    }


    public JSONObject returnJSON(){
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("address", address);
        obj.put("city", city);
        obj.put("country", country);
        return obj;
    }
}