package com.company;

import java.util.ArrayList;

public class Game {
    private static Game game = null;
    private ArrayList<Round> rounds;

    private Game() {
        rounds = new ArrayList<Round>();
        this.mainMenu();
    }

    public static Game getInstance(){
        if(game == null){
            game = new Game();
        }
        return game;
    }

    public void mainMenu(){
        System.out.println(
                "Welcome to Rock Paper Scissors!\n" +
                        "MAIN MENU\n" +
                "=====\n" +
                "1. Type 'play' to play\n" +
                "2. Type 'history' to view your game history\n" +
                "Type 'quit' to stop playing");

    }
}
