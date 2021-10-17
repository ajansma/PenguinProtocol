package com.example.penguinprotocol;

import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.simple.JSONObject;

/**
 *
 */
public class Program {
    private int program_id;
    private String programName;
    private String city;
    private String country;
    private String school;

    //DVC
    public Program() {
        programName = "NEW_PROGRAM";
        city = "NEW_CITY";
        country = "NEW_COUNTRY";
    }

    //EVC
    public Program(String programName, String city, String country, String semester) {
        this.programName = programName;
        this.city = city;
        this.country = country;
    }

    public Program(JSONObject obj) {
        try {
            programName = obj.getString("name");
            city = obj.getString("city");
            school = obj.getString("school");
            country = obj.getString("country");
        } catch (Exception e) {
            System.out.println("Hello");
        }
    }



    /**
     * Getters and Setters:
     */
    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
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

    public String getProgramCountry() {
        return country;
    }
}
