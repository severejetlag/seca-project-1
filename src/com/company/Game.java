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
        return inputScanner.nextLine().toLowerCase();
    }

    private Round getCurrentRound(){
        return rounds.get(rounds.size() - 1);
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

        if(response.equals("play")){
            this.gamePlayMenu();
        }else if(response.equals("history")){
            this.gameHistoryMenu();
        }else{
            System.out.println("Input not recognized, please try again.");
            this.gameMainMenu();
        }
    }

    public void gameHistoryMenu(){

    }

    public void gamePlayMenu(){
        this.state = "playerSelect";
        System.out.println("1. Type 'pvp' for player vs player\n"+
                "2. Type 'pvc' for player vs computer");
        String response = userInputRequest();
        if(response.equals("pvp")){
            System.out.println("Plays player");
            Player player1 = new Player(false, "Player 1");
            Player player2 = new Player(false, "Player 2");
            Round round = new Round(false);
            round.addPlayer(player1);
            round.addPlayer(player2);
            this.rounds.add(round);
            this.gameRoundMenu();
        }else if(response.equals("pvc:")){
            System.out.println("Plays computer");
            Player player1 = new Player(false, "Player 1");
            Computer computer = new Computer();
            Round round = new Round(true);
            round.addPlayer(player1);
            round.addPlayer(computer);
            this.rounds.add(round);
            this.gameRoundMenu();

        }else{
            System.out.println("Input not recognized, please try again.");
            this.gamePlayMenu();
        }
    }

    public void gameRoundMenu(){
        this.state = "round";
        Round currentRound = getCurrentRound();
        Player player1 = currentRound.getPlayer1();

        if(currentRound.isVsComputer()){
            Computer computer = currentRound.getComputer();
            System.out.println("Player 1 type 'rock', 'paper', or 'scissors'");
            player1.setChoice(userInputRequest());
            computer.randomChoice();
            System.out.println(computer.getChoice());
        }
    }

}
