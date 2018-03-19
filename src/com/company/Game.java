package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static Game game = null;
    private ArrayList<Round> rounds;

    private Game() {
        rounds = new ArrayList<>();
    }

    public static Game getInstance(){
        if(game == null){
            game = new Game();
        }
        return game;
    }

    private String userInputRequest(){
        Scanner inputScanner = new Scanner(System.in);
        String userInput = inputScanner.nextLine().toLowerCase();
        if(userInput.equals("quit")){
            System.out.println("\nThanks for playing!");
            System.exit(0);
        }
        return userInput;
    }

    private Round getCurrentRound(){
        return rounds.get(rounds.size() - 1);
    }

    public void gameMainMenu(){
        System.out.println("Welcome to Rock Paper Scissors!\n" +
                "\nMAIN MENU\n" +
                "=====\n" +
                "1. Type 'play' to play\n" +
                "2. Type 'history' to view your game history\n" +
                "Type 'quit' to stop playing");

        String response = userInputRequest();

        switch (response) {
            case "play":
                this.gamePlayMenu();
                break;
            case "history":
                this.gameHistoryMenu();
                break;
            default:
                System.out.println("Input not recognized, please try again.");
                this.gameMainMenu();
                break;
        }
    }

    private void gameHistoryMenu(){
        System.out.println("=== GAME HISTORY ===");
        if(rounds.size()==0){
            System.out.println("There have been no rounds played!");
        }
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

    private void gamePlayMenu(){
        System.out.println("1. Type 'pvp' for player vs player\n"+
                "2. Type 'pvc' for player vs computer");
        String response = userInputRequest();
        switch (response) {
            case "pvp": {
                System.out.println("Player VS. Player");
                Player player1 = new Player(false, "Player 1");
                Player player2 = new Player(false, "Player 2");
                Round round = new Round(false);
                round.addPlayer(player1);
                round.addPlayer(player2);
                this.rounds.add(round);
                this.gameRoundMenuPlayer1();
                break;
            }
            case "pvc": {
                System.out.println("Player VS. Computer");
                Player player1 = new Player(false, "Player 1");
                Player computer = new Player(true, "Computer");
                Round round = new Round(true);
                round.addPlayer(player1);
                round.addPlayer(computer);
                this.rounds.add(round);
                this.gameRoundMenuPlayer1();

                break;
            }
            default:
                System.out.println("Input not recognized, please try again.");
                this.gamePlayMenu();
                break;
        }
    }

    private void gameRoundMenuPlayer1(){
        Round currentRound = getCurrentRound();
        Player player1 = currentRound.getPlayer1();
        System.out.println("Player 1 type 'rock', 'paper', or 'scissors'");
        String userInput = userInputRequest();
        if(player1.getAnswers().contains(userInput)){
            player1.setChoice(userInput);
            gameRoundMenuPlayer2();
        }else{
            System.out.println("Input not recognized, please try again.");
            gameRoundMenuPlayer1();
        }
    }

    private void gameRoundMenuPlayer2() {
        Round currentRound = getCurrentRound();
        Player player2 = currentRound.getPlayer2();

        if (currentRound.isVsComputer()) {
            player2.randomChoice();
            gameCheckWinner();
        } else {
            System.out.println("Player 2 type 'rock', 'paper', or 'scissors'");
            String userInput = userInputRequest();
            if (player2.getAnswers().contains(userInput)) {
                player2.setChoice(userInput);
                gameCheckWinner();
            } else {
                System.out.println("Input not recognized, please try again.");
                this.gameRoundMenuPlayer2();
            }
        }
    }

    private void gameCheckWinner(){
        Round currentRound = getCurrentRound();
        currentRound.checkWinner();
        if(currentRound.getIsTie()){
            System.out.println("\nIt was a tie! There is no winner!\n");
            this.gameMainMenu();
        }else{
            System.out.println(currentRound.getWinner().getName() +
                    " wins with " +
                    currentRound.getWinner().getChoice());
            this.gameMainMenu();
        }
    }

}
