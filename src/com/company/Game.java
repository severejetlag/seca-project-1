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
        System.out.println("=== GAME HISTORY ===");
        for(int i = 0; i < rounds.size(); i++){
            Round round = rounds.get(i);
            if(round.getIsTie()){
                System.out.println(i+1 + ": " + round.getPlayer1().getName() +
                " tied with " +
                round.getPlayer2().getName());
            }else{
                if(round.getPlayer1().getIsWinner()){
                    System.out.println(i+1 + ": " + round.getPlayer1().getName() +
                            " beat " + round.getPlayer2().getName() +
                            " with " + round.getPlayer1().getChoice());
                }else{
                    System.out.println(i+1 + ": " + round.getPlayer2().getName() +
                            " beat " + round.getPlayer1().getName() +
                            " with " + round.getPlayer2().getChoice());
                }
            }
        }
        System.out.println("\n");
        this.gameMainMenu();
    }

    public void gamePlayMenu(){
        this.state = "playerSelect";
        System.out.println("1. Type 'pvp' for player vs player\n"+
                "2. Type 'pvc' for player vs computer");
        String response = userInputRequest();
        if(response.equals("pvp")){
            System.out.println("Player VS. Player");
            Player player1 = new Player(false, "Player 1");
            Player player2 = new Player(false, "Player 2");
            Round round = new Round(false);
            round.addPlayer(player1);
            round.addPlayer(player2);
            this.rounds.add(round);
            this.gameRoundMenu();
        }else if(response.equals("pvc")){
            System.out.println("Player VS. Computer");
            Player player1 = new Player(false, "Player 1");
            Player computer = new Player(true, "Computer");
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
        Player player2 = currentRound.getPlayer2();
        System.out.println("Player 1 type 'rock', 'paper', or 'scissors'");
        player1.setChoice(userInputRequest());

        if(currentRound.isVsComputer()){
            player2.randomChoice();
        }else{
            System.out.println("Player 2 type 'rock', 'paper', or 'scissors'");
            player2.setChoice(userInputRequest());
        }

        currentRound.checkWinner();
        if(currentRound.getIsTie()){
            System.out.println("It was a tie! There is no winner!");
            this.gameMainMenu();
        }else{
            System.out.println(currentRound.getWinner().getName() +
                    " wins with " +
                    currentRound.getWinner().getChoice());
            this.gameMainMenu();
        }

    }

}
