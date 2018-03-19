package com.company;

import java.util.ArrayList;

public class Round {
    private Player winner;
    private boolean isTie;

    public boolean isVsComputer() {
        return isVsComputer;
    }

    private boolean isVsComputer;
    private ArrayList players;

    Round(){}

    public Round(boolean isVsComputer) {
        this.isVsComputer = isVsComputer;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public Player getPlayer1(){
        return (Player) players.get(0);
    }

    public Player getPlayer2(){
        return (Player) players.get(1);
    }
    public Computer getComputer(){
        return (Computer) players.get(1);
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public Player getWinner(){
        return this.winner;
    }

    public void checkWinner(){

        Player player1 = this.getPlayer1();

        if(this.isVsComputer){
            Computer computer = this.getComputer();
            if(player1.getChoice().equals("rock")){
                if(computer.getChoice().equals("scissors")){
                    winner = player1;
                }else if(computer.getChoice().equals("paper")){
                    winner = computer;
                }else if(computer.getChoice().equals("rock")){
                    isTie = true;
                }
            } else if(player1.getChoice().equals("scissors")){
                if(computer.equals("paper")){
                    winner = player1;
                }else if(computer.getChoice().equals("rock")){
                    winner = computer;
                }else if(computer.getChoice().equals("scissors")){
                    isTie = true;
                }
            } else if(player1.getChoice().equals("paper")){
                if(computer.getChoice().equals("rock")){
                    winner = player1;
                }else if(player1.getChoice().equals("scissors")){
                    winner = computer;
                }else if(computer.getChoice().equals("paper")){
                    isTie = true;
                }
            }else{
                Computer computer = this.getComputer();
                    if(player1.getChoice().equals("rock")){
                        if(computer.getChoice().equals("scissors")){
                            winner = player1;
                        }else if(computer.getChoice().equals("paper")){
                            winner = computer;
                        }else if(computer.getChoice().equals("rock")){
                            isTie = true;
                        }
                    } else if(player1.getChoice().equals("scissors")){
                        if(computer.equals("paper")){
                            winner = player1;
                        }else if(computer.getChoice().equals("rock")){
                            winner = computer;
                        }else if(computer.getChoice().equals("scissors")){
                            isTie = true;
                        }
                    } else if(player1.getChoice().equals("paper")){
                        if(computer.getChoice().equals("rock")){
                            winner = player1;
                        }else if(player1.getChoice().equals("scissors")){
                            winner = computer;
                        }else if(computer.getChoice().equals("paper")){
                            isTie = true;
                        }
                    }

        }


    }
}
