package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game game = Game.getInstance();
        String input = getUserInput();
        System.out.println(input);
    }

    private static String getUserInput(){
        Scanner inputScanner = new Scanner(System.in);
        String userInput = inputScanner.nextLine();

        return userInput;
    }
}
