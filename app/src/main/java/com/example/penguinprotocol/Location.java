package com.example.penguinprotocol;

//import org.json.simple.JSONObject;

import org.json.JSONObject;

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
        try {
            name = obj.getString("name");
            address = obj.getString("address");
            city = obj.getString("city");
            country = obj.getString("country");
        }
        catch(Exception e){
            System.out.println("FAIL");
        }
    }

/*
    public JSONObject returnJSON(){
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("address", address);
        obj.put("city", city);
        obj.put("country", country);
        return obj;
    }

 */

    /**
     * Getters and Setters:
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }
}

