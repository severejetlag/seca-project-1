package com.company;

import java.util.ArrayList;

public class Round {

    private boolean isTie;
    private boolean isVsComputer;
    private ArrayList<Player> players;

    public Round(boolean isVsComputer) {
        this.isVsComputer = isVsComputer;
        players = new ArrayList<>();
    }

    public boolean isVsComputer() {
        return isVsComputer;
    }

    // Looked up IndexOutOfBoundsException
    // https://stackoverflow.com/questions/36136526/java-try-catch-not-handling-indexoutofboundsexception
    public Player getPlayer1(){
        try{
            return  players.get(0);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Improper player value, restarting!");
            Game game = Game.getInstance();
            game.gameMainMenu();
        }
        return null;
    }

    public Player getPlayer2(){
        try{
            return players.get(1);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Improper player value, restarting!");
            Game game = Game.getInstance();
        }
        return null;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public boolean getIsTie(){
        return this.isTie;
    }

    public void checkWinner() {
        Player player1 = this.getPlayer1();
        Player player2 = this.getPlayer2();
        if (player1.getChoice().equals("rock")) {
            if (player2.getChoice().equals("scissors")) {
                player1.setIsWinner();
            } else if (player2.getChoice().equals("paper")) {
                player2.setIsWinner();
            } else if (player2.getChoice().equals("rock")) {
                isTie = true;
            }
        } else if (player1.getChoice().equals("scissors")) {
            if (player2.getChoice().equals("paper")) {
                player1.setIsWinner();
            } else if (player2.getChoice().equals("rock")) {
                player2.setIsWinner();
            } else if (player2.getChoice().equals("scissors")) {
                isTie = true;
            }
        } else if (player1.getChoice().equals("paper")) {
            if (player2.getChoice().equals("rock")) {
                player1.setIsWinner();
            } else if (player1.getChoice().equals("scissors")) {
                player2.setIsWinner();
            } else if (player2.getChoice().equals("paper")) {
                isTie = true;
            }
        }
    }

    public Player getWinner(){
        Player returnPlayer = null;
        for(int i = 0; i < this.players.size(); i++){
            if(this.players.get(i).getIsWinner()){
                returnPlayer = this.players.get(i);
            }
        }
        return returnPlayer;
    }
}
