package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    private boolean isComputer;
    private String choice;
    private String name;
    private boolean isWinner = false;
    private static ArrayList<String> answers = new ArrayList<String>(){{
        add("rock");
        add("paper");
        add("scissors");
    }};

    public Player(boolean isComputer, String name) {
        this.isComputer = isComputer;
        this.name = name;
    }
    public ArrayList<String> getAnswers(){
        return answers;
    }
    public void setChoice(String choice) {
        this.choice = choice;
    }
    public String getChoice() {
        return choice;
    }
    public String getName(){
        return this.name;
    }
    public void setIsWinner(){
        this.isWinner = true;
    }
    public boolean getIsWinner(){
        return this.isWinner;
    }

    public void randomChoice(){
        // Looked up how to get random number in java
        //https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
        Random random = new Random();
        this.choice = answers.get(random.nextInt(2 - 0 + 1) + 0);
    }

}
