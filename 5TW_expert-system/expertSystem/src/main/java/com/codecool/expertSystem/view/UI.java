package com.codecool.expertSystem.view;

import java.util.Scanner;

public class UI {
    private Scanner scanner = new Scanner(System.in);

    public String userInput(String message) {
        System.out.println(message);
        return scanner.nextLine().toLowerCase();
    }

    public void display(String name) {
        System.out.println("\nPerfect place for You is " + name + ".\n");
    }

    public void clearScreen() {
        System.out.println("\033[H\033[2J");
    }
}