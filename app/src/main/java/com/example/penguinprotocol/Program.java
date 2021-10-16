package com.example.penguinprotocol;

/**
 *
 */
public class Program {
    private String programName;
    private String city;
    private String country;
    private String semester;

    //DVC
    public Program() {
        programName = "NEW_PROGRAM";
        city = "NEW_CITY";
        country = "NEW_COUNTRY";
        semester = "NEW_SEMESTER";
    }

    //EVC
    public Program(String programName, String city, String country, String semester) {
        this.programName = programName;
        this.city = city;
        this.country = country;
        this.semester = semester;
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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
