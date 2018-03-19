package com.company;

public class Player {
    protected boolean isComputer;
    protected String choice;
    protected String name;

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
