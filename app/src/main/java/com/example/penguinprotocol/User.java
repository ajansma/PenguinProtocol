package com.example.penguinprotocol;
import org.json.simple.JSONObject;

public class User {

    private String name;
    private String gradSemester;
    private DatabaseHandler database = new DatabaseHandler();

    public User(int program, String name, String gradSemester){
        this.program = program;
        this.name = name;
        this.gradSemester = gradSemester;
    }

    public User(JSONObject obj){
        name = obj.get("name").toString();
        userID = (int)(obj.get("uid"));
        gradSemester = obj.get("sem_attended").toString();
        program = (int)(obj.get("program"));
    }

    public JSONObject toJSON(){
        JSONObject obj = new JSONObject();
        obj.put("uid", userID);
        obj.put("name", name);
        obj.put("sem_attended", gradSemester);
        obj.put("program", program);
        return obj;
    }

    public void sendData(){

    }

    public void postData(){

    }



}
