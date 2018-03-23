package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Singleton style from in class labs
        Game game = Game.getInstance();
        game.gameMainMenu();
    }
}
