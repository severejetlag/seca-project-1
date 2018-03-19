package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static Game game = null;
    private String state;
    private ArrayList<Round> rounds;

    private Game() {
        rounds = new ArrayList<Round>();
    }

    public static Game getInstance(){
        if(game == null){
            game = new Game();
        }
        return game;
    }

    public void setGameState(String state) {
        this.state = state;
    }

    public String getGameState(){
        return this.state;
    }

    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public void addRound(Round round) {
        this.rounds.add(round);
    }

    private String userInputRequest(){
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextLine();
    }

    public void gameMainMenu(){
        this.state = "mainMenu";
        System.out.println("Welcome to Rock Paper Scissors!\n" +
                "MAIN MENU\n" +
                "=====\n" +
                "1. Type 'play' to play\n" +
                "2. Type 'history' to view your game history\n" +
                "Type 'quit' to stop playing");

        String response = userInputRequest();

        if(response.toLowerCase().equals("play")){
            this.gamePlayMenu();
        }
    }

    public void gamePlayMenu(){
        this.state = "playerSelect";
        System.out.println("1. Type 'pvp' for player vs player\n"+
                "2. Type 'pvc' for player vs computer");
        String response = userInputRequest();
        if(response.toLowerCase().equals("pvp")){
            System.out.println("Plays player");
        }else if(response.toLowerCase().equals("pvc:")){
            System.out.println("Plays computer");
        }else{
            System.out.println("Input not recognized, please try again.");
            this.gamePlayMenu();
        }
    }


}
