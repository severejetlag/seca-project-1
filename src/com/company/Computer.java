package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Computer extends Player{
    private ArrayList<String> answers = new ArrayList<String>(){{
       add("rock");
       add("paper");
       add("scissors");
    }};
    Computer(){}

    public Computer(boolean isComputer, String name) {
        super(true, "computer");
    }

    public void randomChoice(){
        Random random = new Random();
        this.choice = answers.get(random.nextInt(2 - 0 + 1) + 0);
    }
}
