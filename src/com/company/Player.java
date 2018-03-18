package com.company;

public class Player {
    protected boolean isComputer;
    protected String choice;

    Player(){};

    public Player(boolean isComputer) {
        this.isComputer = isComputer;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
    public String getChoice() {
        return choice;
    }
}
