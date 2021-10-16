package com.example.penguinprotocol;

import org.json.JSONArray;
import org.json.simple.JSONObject;

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

    public Program(JSONObject obj){
        programName = obj.get("program").toString();
        city = obj.get("city").toString();
        school = obj.get("school").toString();
        country = obj.get("country").toString();
    }

    public JSONObject returnJSON(){
        JSONObject obj = new JSONObject();
        obj.put("name", programName);
        obj.put("school", school);
        obj.put("city", city);
        obj.put("country", country);
        return obj;
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
}
