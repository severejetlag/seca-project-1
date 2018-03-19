package com.company;

import java.util.ArrayList;

public class Round {
    private Player winner;
    private boolean isTie;
    private ArrayList<Player> players;

    Round(){}

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public Player getWinner(){
        return this.winner;
    }

    public void checkWinner(){
        if(players.get(0).choice.equals("rock")){
            if(players.get(1).choice.equals("scissors")){
                winner = players.get(0);
            }else if(players.get(1).choice.equals("paper")){
                winner = players.get(1);
            }else if(players.get(1).choice.equals("rock")){
                isTie = true;
            }
        } else if(players.get(0).choice.equals("scissors")){
            if(players.get(1).choice.equals("paper")){
                winner = players.get(0);
            }else if(players.get(1).choice.equals("rock")){
                winner = players.get(1);
            }else if(players.get(1).choice.equals("scissors")){
                isTie = true;
            }
        } else if(players.get(0).choice.equals("paper")){
            if(players.get(1).choice.equals("rock")){
                winner = players.get(0);
            }else if(players.get(1).choice.equals("scissors")){
                winner = players.get(1);
            }else if(players.get(1).choice.equals("paper")){
                isTie = true;
            }
        }

    }
}
