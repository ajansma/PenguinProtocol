package com.example.penguinprotocol;

public class Review {
    private User user;
    private Program program;
    private String entryDate;

    public Review() {
        user = new User();
        program = new Program();
        entryDate = "NULL_DATE";
    }

    public Review(User user, Program program, String entryDate) {
        this.user = user;
        this.program = program;
        this.entryDate = entryDate;
    }

    /**
     * Getters and Setters:
     */
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
}
