package com.company;

public class Player {
    private boolean isComputer;
    protected String choice;
    private String name;

    Player(){}

    public Player(boolean isComputer, String name) {
        this.isComputer = isComputer;
        this.name = name;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
    public String getChoice() {
        return choice;
    }
}
